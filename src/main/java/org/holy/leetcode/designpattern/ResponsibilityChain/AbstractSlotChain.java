package org.holy.leetcode.designpattern.ResponsibilityChain;

public abstract class AbstractSlotChain implements SlotChain {

    private AbstractSlotChain next = null;

    /**
     * 此处模拟 sentinel slot 插槽设计 ；
     * entry 入口凭证
     */
    public void fireEntry() {
        if(next != null){
            next.handle();
        }
    }

    /**
     * 具体的处理方法
     */
    public void handle(){
        entry();
        fireEntry();
    }

    public void setNext(AbstractSlotChain next){
        this.next = next;
    }

    public AbstractSlotChain getNext(){
        return this.next;
    }
}
