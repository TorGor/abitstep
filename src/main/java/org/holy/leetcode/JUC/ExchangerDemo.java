package org.holy.leetcode.JUC;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        new Thread() {
            @Override
            public void run() {
                String data1="data1";
                try {
                    System.out.println(Thread.currentThread().getName()+"交换前的数据:"+data1);
                    String data2=exchanger.exchange(data1);
                    System.out.println(Thread.currentThread().getName()+"交换后的数据:"+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                String data2="data2";
                try {
                    System.out.println(Thread.currentThread().getName()+"交换前的数据:"+data2);
                    String data1=exchanger.exchange(data2);
                    System.out.println(Thread.currentThread().getName()+"交换后的数据:"+data1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
