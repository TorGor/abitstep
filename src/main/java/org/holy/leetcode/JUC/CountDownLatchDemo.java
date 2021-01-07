package org.holy.leetcode.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * 等待其他任务全部执行完，才会执行接下来的任务
 *
 * 同样 sync 继承 AQS ，以 CAS 机制控制的 共享锁
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        // 确保 state 值是线程的总数，这样才会 countDown 直至为 0
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 5; i > 0; i--) {
            int finalI = i;
            new Runnable() {
                @Override
                public void run() {
                    System.out.println(" =========== " + finalI + "ready：");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }.run();
        }

        try {
            countDownLatch.await();
            System.out.println("++++++++++++++ 开始：");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }
}
