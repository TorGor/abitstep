package org.holy.leetcode.algorithm.ratelimit;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * 漏桶控制器类
 *
 * 漏桶：
 * 请求：可以把请求入口当作水龙头，流量任意调节，
 * 桶：用来装已经载入的请求量，
 * 底漏：用来匀速流出请求量。
 *
 * 当桶满了，流量直接溢出抛弃，只有当漏出的请求消耗时，才有有新的流量进入。
 *
 *
 * 缺点：
 * 1.不支持突发大流量，因为漏出的流量是恒定的。
 * 2.需要使用单独的定时任务线程来处理任务
 */
public class LeakyBucketRateLimit implements RateLimit, Runnable {

    /**
     * 漏桶，使用阻塞队列实现
     * 原本应该实现 Node 接口，此处直接使用 jdk 的 blockQueen
     */
    private BlockingQueue<Integer> leakyBucket;

    /**
     * QPS 允许量
     */
    private Integer limitInSecond;

    /**
     * 定时任务处理
     */
    private ScheduledExecutorService scheduledExecutorService;


    public LeakyBucketRateLimit(Integer size, Integer limitInSecond) {
        this.limitInSecond = limitInSecond;
        this.leakyBucket = new LinkedBlockingQueue<>(size);

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 一秒内应该每隔多久执行一次 = QPS
        long interval = (1000 * 1000 * 1000) / limitInSecond;
        // 定时任务执行，单位（千分之一微妙）
        scheduledExecutorService.scheduleAtFixedRate(this, 0, interval, TimeUnit.NANOSECONDS);
    }


    /**
     * 判断是否允许通过
     *
     * @return
     */
    @Override
    public boolean canPass(Node node) {
        if (leakyBucket.remainingCapacity() == 0) {
            return false;
        }
        System.out.println("run: off stary ,return off result " );
        return leakyBucket.offer(1);
    }


    @Override
    public void run() {
        Integer thread = leakyBucket.poll();
        System.out.println("run: get start " );
        if (Objects.nonNull(thread)) {
            System.out.println("run: get - " + thread);
        }
    }
}
