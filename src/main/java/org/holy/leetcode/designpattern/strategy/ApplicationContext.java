package org.holy.leetcode.designpattern.strategy;

public class ApplicationContext {

    private Strategy strategy;

    /**
     *
     * @param strategy
     */
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 调用策略
     */
    public void invokeStrategy(){
        strategy.getGirl();
    }

}
