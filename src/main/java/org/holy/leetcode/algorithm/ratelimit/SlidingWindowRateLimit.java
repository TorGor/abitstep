package org.holy.leetcode.algorithm.ratelimit;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 控制器
 * <p>
 * 计数器：滑动窗口限流
 * 与其说是滑动，不如说是固定窗口数量，替换下标窗口
 * <p>
 * ex：QPS = 1000；slidingWindow.size=10;slidingWindow.intervel=100ms;
 * <p>
 * QPS = size * intervel;
 * idx =
 */
public class SlidingWindowRateLimit implements RateLimit {

    /**
     * 已经通过的请求
     */
    private AtomicInteger passed;

    /**
     * 限流阀值 QPS
     */
    private Integer limit;

    /**
     * 使用原子操作数组
     */
    private AtomicReferenceArray<Window> array;

    /**
     * 构造
     *
     * @param size
     * @param
     */
    public SlidingWindowRateLimit(int size, int limit) {
        this.array = new AtomicReferenceArray<>(size);
        this.limit = limit;
        this.passed = new AtomicInteger(0);
    }

    /**
     * 判断是否允许通过
     *
     * @param node
     * @return
     */
    @Override
    public boolean canPass(Node node) {
        // 计算窗口，并返回，如果滑动将滑动窗口初始化
        Window currentWindow = currentWindown(System.currentTimeMillis());
        currentWindow.add();

        System.out.println("***** window pass:" + currentWindow.getPassed());
        /*
         * 当前窗口是否允许通过
         */
        if (currentWindow.getPassed() > limit/array.length()) {
            return false;
        }
        int pass = passed.addAndGet(1);
        System.out.println("***** total pass:" + pass);
        return true;
    }

    /**
     * 返回当前窗口
     *
     * @param timeMillis
     * @return
     */
    private Window currentWindown(long timeMillis) {
        int idx = calculateWindowIdx(timeMillis);
        long windowStartTime = calculateWindowStart(timeMillis);

        Window old = array.get(idx);
        while (true) {
            if (old == null) {
                System.out.println(" new win");
                Window window = new Window(100, windowStartTime);
                if (array.compareAndSet(idx, null, window)) {
                    return window;
                } else {
                    Thread.yield();
                }
            }
            if (windowStartTime == old.getWindowStart()) {
                /*
                 *     B0       B1      B2     B3      B4
                 * ||_______|_______|_______|_______|_______||___
                 * 200     400     600     800     1000    1200  timestamp
                 *                             ^
                 *                          time=888
                 *            startTime of Bucket 3: 800, so it's up-to-date
                 *
                 * If current windowStart is equal to the start timestamp of old bucket,
                 * that means the time is within the bucket, so directly return the bucket.
                 */
                System.out.println(" old win");
                return old;
            }
            if (windowStartTime > old.getWindowStart()) {
                /*
                 *
                 * when window to last，the index will be the first，then startTime > old.startTime
                 * should reset window to now startTime,value reset to 0
                 */
                System.out.println(" sliding win");
                return old.resetWindownTo(windowStartTime);
            }
            // should not be hell
            if (windowStartTime < old.getWindowStart()) {
                System.out.println(" wont win");
                return new Window(100, windowStartTime);
            }
        }
    }

    /**
     * 计算窗口下标
     *
     * @param timeMillis
     * @return
     */
    private int calculateWindowIdx(long timeMillis) {
//        long timeId = timeMillis / windowLengthInMs;
        long timeId = timeMillis / 100;
        // Calculate current index so we can map the timestamp to the leap array.
        return (int) (timeId % array.length());
    }

    /**
     * 计算窗口的开始时间
     *
     * @param timeMillis
     * @return
     */
    private long calculateWindowStart(long timeMillis) {
//        return timeMillis - timeMillis % windowLengthInMs;
//        return timeMillis - timeMillis % (limit / array.length());
        return timeMillis - timeMillis % 100;
    }

    /**
     * 所有窗口内的已通过请求数
     *
     * @return
     */
    private int getPassed() {
        System.out.println("***** array length:" + array.length());
        for (int i = 0; i < array.length(); i++) {
            if (array.get(i) == null) {
                continue;
            }
            System.out.println(array.get(i).getWindowStart());
//            passed.addAndGet(array.get(i).getPassed());

        }
        return passed.get();
    }

}
