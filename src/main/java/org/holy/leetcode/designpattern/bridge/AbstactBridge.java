package org.holy.leetcode.designpattern.bridge;

public abstract class AbstactBridge {

    private Driver driver;

    /**
     * 另一个独立变化的抽象
     */
    public abstract void crudOption();


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
