package org.holy.leetcode.designpattern.ResponsibilityChain;

public class Test {
    public static void main(String[] args) {

        FlowSlotChain chain = new FlowSlotChain();
        DegradeSlotChain degradeSlotChain = new DegradeSlotChain();
        MyCustomerSlotChain customerSlotChain = new MyCustomerSlotChain();

        chain.setNext(degradeSlotChain);
        degradeSlotChain.setNext(customerSlotChain);

        chain.handle();
    }
}
