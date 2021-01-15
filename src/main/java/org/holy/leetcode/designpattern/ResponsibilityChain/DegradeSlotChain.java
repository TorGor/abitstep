package org.holy.leetcode.designpattern.ResponsibilityChain;

public class DegradeSlotChain extends AbstractSlotChain {
    /**
     * 此处模拟 sentinel slot 插槽设计 ；
     * entry 入口凭证
     */
    @Override
    public void entry() {
        System.out.println("DegradeSlotChain entry success ,token can be use");
    }

}
