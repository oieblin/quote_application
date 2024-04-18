package com.ccufs.quotes.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * The type In mem cache.
 */
@Component
public class InMemCacheImpl implements InMemCache {


  private final Map<String, Object> cache;

  /**
   * Instantiates a new In mem cache.
   *
   * @param cache the cache
   */
  public InMemCacheImpl(Map<String, Object> cache) {
    this.cache = cache;
  }

  private static final int RATE = 100;

  /**
   * Instantiates a new In mem cache.
   */
  @Autowired
  public InMemCacheImpl() {
    cache = new LinkedHashMap<>() {
      @Override
      public boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return cache.size() > RATE;
      }
    };
  }

  @Override
  public void put(String key, Object value) {
    cache.put(key, value);
  }

  @Override
  public Object get(String key) {
    return cache.get(key);
  }

  @Override
  public void evict(String key) {
    cache.remove(key);
  }

  @Override
  public void clear() {
    cache.clear();
  }

  @Override
  public boolean containsKey(String key) {
    return cache.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return cache.containsValue(value);
  }

}
