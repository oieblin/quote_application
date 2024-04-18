package com.ccufs.quotes.cache;


import org.springframework.stereotype.Service;

/**
 * The type In mem cache service.
 */
@Service
public class InMemCacheService {

  private final InMemCache inMemCache;


  /**
   * Instantiates a new In mem cache service.
   *
   * @param inMemCache the in mem cache
   */
  public InMemCacheService(InMemCache inMemCache) {

    this.inMemCache = inMemCache;
  }

  /**
   * Add to cache.
   *
   * @param key   the key
   * @param value the value
   */
  public void addToCache(String key, Object value) {

    inMemCache.put(key, value);
  }

  /**
   * Gets from cache.
   *
   * @param key the key
   * @return the from cache
   */
  public Object getFromCache(String key) {

    return inMemCache.get(key);
  }

  /**
   * Remove from cache.
   *
   * @param key the key
   */
  public void removeFromCache(String key) {

    inMemCache.evict(key);
  }

  /**
   * Clear cache.
   */
  public void clearCache() {

    inMemCache.clear();
  }

  /**
   * If cache key exists boolean.
   *
   * @param key the key
   * @return the boolean
   */
  public boolean ifCacheKeyExists(String key) {

    return inMemCache.containsKey(key);
  }

  /**
   * If cache value exists boolean.
   *
   * @param key   the key
   * @param value the value
   * @return the boolean
   */
  public boolean ifCacheValueExists(String key, Object value) {
    return inMemCache.containsKey(key) && inMemCache.get(key).equals(value);
  }


}
