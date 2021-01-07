package org.holy.leetcode.designpattern.decorator;

/**
 * Mybatis cache 装饰器模式 简化版本
 */
public interface Cache {
    /**
     * 获取缓存
     * @param key
     * @return
     */
    Object getObject(Object key);
}
