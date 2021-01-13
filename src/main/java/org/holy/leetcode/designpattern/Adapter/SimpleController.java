package org.holy.leetcode.designpattern.Adapter;

public class SimpleController implements Controller {

    /**
     * 处理请求
     */
    @Override
    public void handleRequest() {
        System.out.println(" do SimpleController logic");
    }
}
