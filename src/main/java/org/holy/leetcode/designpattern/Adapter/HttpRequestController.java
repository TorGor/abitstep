package org.holy.leetcode.designpattern.Adapter;

public class HttpRequestController implements Controller {

    /**
     * 处理请求
     */
    @Override
    public void handleRequest() {
        System.out.println(" do HttpRequestController logic");
    }
}
