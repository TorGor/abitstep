package org.holy.leetcode.algorithm.ratelimit;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        // ***************  漏桶测试 ***************
//        LeakyBucketRateLimit bucket = new LeakyBucketRateLimit(5, 1);
//        try {
//            bucket.run();
//            Node node = new StatisticNode();
//            for (int i = 0; i < 15; i++) {
//                System.out.println(bucket.canPass(node));
//                Thread.sleep(500);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // ***************  令牌桶测试 ***************

        // ***************  滑动窗口限流测试 ***************
        SlidingWindowRateLimit slidingLimit = new SlidingWindowRateLimit(10, 100);
        /*
         * limit/win.size = 10
         * 每个 window 只能通过 10 个请求
         *
         */
        try {
            Node node = new StatisticNode();
            for (int i = 0; i < 100; i++) {
                System.out.println(slidingLimit.canPass(node));
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ReentrantLock reentrantLock;
    }
}
