package org.holy.leetcode.designpattern.bridge;

public class WriteOption extends AbstactBridge{

    /**
     * 另一个独立变化的抽象
     */
    @Override
    public void crudOption() {
        this.getDriver().getConnect();
        System.out.println(" 执行写操作。。。。写入数据XXX");
    }
}
