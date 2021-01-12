package org.holy.leetcode.designpattern.strategy;

public class WishStrategy implements Strategy {
    /**
     * 追女孩
     */
    @Override
    public void getGirl() {
        System.out.println("Wish: Send House !");
    }
}
