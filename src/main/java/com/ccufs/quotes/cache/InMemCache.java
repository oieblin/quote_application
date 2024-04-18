package com.ccufs.quotes.cache;

/**
 * The interface In mem cache.
 */
public interface InMemCache {
  /**
   * Put.
   *
   * @param key   the key
   * @param value the value
   */
  void put(String key, Object value);

  /**
  * Get object.
  *
  * @param key the key
  * @return the object
  */
  Object get(String key);

  /**
   * Evict.
   *
   * @param key the key
   */
  void evict(String key);

  /**
   * Clear.
   */
  void clear();

  /**
   * Contains key boolean.
   *
   * @param key the key
   * @return the boolean
   */
  boolean containsKey(String key);

  /**
   * Contains value boolean.
   *
   * @param value the value
   * @return the boolean
   */
  boolean containsValue(Object value);
}
