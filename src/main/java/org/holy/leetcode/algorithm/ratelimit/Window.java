package org.holy.leetcode.algorithm.ratelimit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 窗口类
 */
public class Window {
    /**
     * Time length of a single window bucket in milliseconds.
     * 单位 ms
     */
    private final long windowLengthInMs;

    /**
     * Start timestamp of the window in milliseconds.
     * 开始时间：时间戳
     */
    private long windowStart;

    /**
     * Statistic data.
     * 在该窗口的数据
     */
    private AtomicInteger count;


    public Window(long windowLengthInMs, long windowStart) {
        this.windowLengthInMs = windowLengthInMs;
        this.windowStart = windowStart;
        this.count = new AtomicInteger(0);
    }

    /**
     *
     * @return
     */
    public int add(){
        return count.incrementAndGet();
    }

    /**
     * 重置该窗口，或者称为滑动该窗口
     * @param startTime
     * @return
     */
    public Window resetWindownTo(long startTime){
        this.windowStart = startTime;
        this.count.set(0);
        return this;
    }

    /**
     * 是否在窗口内
     * @param timeMillis
     * @return
     */
    public boolean isTimeInWindow(long timeMillis){
        return windowStart <= timeMillis && timeMillis < windowStart + windowLengthInMs;
    }

    /**
     * 获取窗口开始时间
     *
     * @return
     */
    public long getWindowStart(){
        return windowStart;
    }

    /**
     * 获取当前通过请求数
     *
     * @return
     */
    public int getPassed(){
        return count.get();
    }




}