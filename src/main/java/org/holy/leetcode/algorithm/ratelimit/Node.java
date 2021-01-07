package org.holy.leetcode.algorithm.ratelimit;

/**
 * 自定义接口
 * Node 存储请求
 */
public interface Node {

    /**
     * add one
     * @return boolean
     */
    boolean add();

    /**
     * remove one
     * @return boolean
     */
    boolean remove();

}
