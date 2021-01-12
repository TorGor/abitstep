package org.holy.leetcode.designpattern.strategy;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();

        context.setStrategy(new TomStrategy());
        context.invokeStrategy();

        context.setStrategy(new WishStrategy());
        context.invokeStrategy();

        context.setStrategy(new YohnStrategy());
        context.invokeStrategy();
    }
}
