package org.holy.leetcode.JUC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

public class ThreadParkTest {

    private static Logger log = LoggerFactory.getLogger(ThreadParkTest.class);


    public static void main(String[] args) {

        Thread t0 = new Thread(() -> {
            Thread current = Thread.currentThread();
//            LockSupport.unpark(current);
            log.info("current Thread name:{}", current.getName());
            for (int i = 0; i < 3; i++) {
                log.info("for循环第{}次，begin", i + 1);
                log.info("准备park当前线程：{}", current.getName());
                LockSupport.park();
                boolean first = Thread.interrupted();
                boolean second = Thread.interrupted();
                log.info("线程{}阻断后又运行了 first={}, second={}",current.getName(),first, second);
                log.info("线程{}阻断后又运行了", current.getName());
                log.info("for循环第{}次，end", i + 1);
            }
        }, "t0");

        t0.start();

        try {
            log.info("休眠…………");
            Thread.sleep(2000);

//            log.info("调用LockSupport.unpark方法，唤醒线程{}", t0.getName());
//            LockSupport.unpark(t0);

            log.info("调用t0.interrupt，唤醒线程{}   t0.isInterrupted()={}", t0.getName(),t0.isInterrupted());
            t0.interrupt();
            log.info("t0.isInterrupted()={}", t0.isInterrupted());

//            log.info("调用Thread.interrupted()，唤醒线程{}   t0.isInterrupted()={}", t0.getName(),t0.isInterrupted());
//            Thread.interrupted();
//            log.info("t0.isInterrupted()={}", t0.isInterrupted());

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
