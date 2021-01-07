package org.holy.leetcode.JUC;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 */
public class semaphoreDemo {

    public static void main(String[] args) {
        int threadSize = 10 ;
        Semaphore semaphore = new Semaphore(threadSize);

        while (threadSize > 0) {
            threadSize--;
            new Runnable(){
                @Override
                public void run() {
                    try {
                        semaphore.acquire(1);
                        System.out.println(" ============ 消耗了 permits ，还剩 ：" + semaphore.availablePermits() );

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.run();
        }

    }

}
