package org.holy.leetcode.designpattern.Adapter;

/**
 * 适配器用来适配原有的不能修改的老接口
 * 让老接口适配新的业务逻辑，新老接口可以通过统一的 handle 调用
 */
public interface Adapter {

    /**
     * 用来取代 if else 判断适配实例
     * @return
     */
    boolean support(Object handler);

    /**
     * 适配器核心，被适配对象处理逻辑
     */
    void handle(Object handler);
}
