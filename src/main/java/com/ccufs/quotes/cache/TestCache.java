package com.ccufs.quotes.cache;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Test cache.
 */
@RestController
@RequestMapping("/api/v1/cache")
public class TestCache {

  private final Map<String, Object> cache;

  /**
   * Instantiates a new Test cache.
   *
   * @param cache the cache
   */
  public TestCache(Map<String, Object> cache) {
    this.cache = cache;
  }

  private static final int RATE = 3;

  /**
   * Instantiates a new Test cache.
   */
  @Autowired
  public TestCache() {
    cache = new LinkedHashMap<>() {
      @Override
      public boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return cache.size() > RATE;
      }
    };
  }

  /**
   * Gets keys.
   *
   * @return the keys
   */
  @GetMapping("/getKeys")
  public Set<String> getKeys() {
    return cache.keySet();
  }

  /**
   * Gets values.
   *
   * @return the values
   */
  @GetMapping("/getValues")
  public Collection<Object> getValues() {
    return cache.values();
  }


  /**
   * Test cache put string.
   *
   * @return the string
   */
  @GetMapping("/put")
  public String testCachePut() {
    cache.put("key1", "value1");
    cache.put("key2", "value2");
    cache.put("key3", "value3");
    cache.put("key4", "value4");
    return "This message was cached.";
  }

  /**
   * Test cache contains key boolean.
   *
   * @return the boolean
   */
  @GetMapping("/contain")
  public boolean testCacheContainsKey() {
    return cache.containsKey("key3");
  }

  /**
   * Test cache remove.
   */
  @GetMapping("/remove")
  public void testCacheRemove() {
    cache.remove("key1");
  }

}
