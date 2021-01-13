package org.holy.leetcode.designpattern.Adapter;

public class HttpRequestControllerAdapter implements Adapter {

    /**
     * 用来取代 if else 判断适配实例
     *
     * @return
     */
    @Override
    public boolean support(Object handler) {
        return (handler instanceof HttpRequestController);
    }

    /**
     * 适配器核心，此处给 simpleController 适配
     */
    @Override
    public void handle(Object handler) {
        ((HttpRequestController)handler).handleRequest();
    }
}
