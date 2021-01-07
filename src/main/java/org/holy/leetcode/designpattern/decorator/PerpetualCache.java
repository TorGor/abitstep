package org.holy.leetcode.designpattern.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始 cache
 */
public class PerpetualCache implements Cache {

  private String id;

  private Map<Object, Object> cache = new HashMap<Object, Object>();

  public PerpetualCache(String id) {
    this.id = id;
  }

  @Override
  public Object getObject(Object key) {
    return cache.get(key);
  }

}