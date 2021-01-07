package org.holy.leetcode.algorithm.ratelimit;

/**
 * 限流控制接口
 *
 */
public interface RateLimit {

    /**
     * 判断是否允许通过
     *
     * @return
     */
    boolean canPass(Node node);

}
