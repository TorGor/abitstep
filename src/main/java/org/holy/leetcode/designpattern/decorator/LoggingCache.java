package org.holy.leetcode.designpattern.decorator;

public class LoggingCache implements Cache {

  // 此处为传递的 cache 接口
  private Cache delegate;

  protected int requests = 0;
  protected int hits = 0;

  public LoggingCache(Cache delegate) {
    this.delegate = delegate;
  }

  @Override
  public Object getObject(Object key) {
    requests++;
    final Object value = delegate.getObject(key);
    if (value != null) {
      hits++;
    }
    // do my logging
//    log.debug("Cache Hit Ratio [" + getId() + "]: " + getHitRatio());

    return value;
  }

}