package com.ccufs.quotes.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type In mem cache impl test.
 */
@ExtendWith(MockitoExtension.class)
class InMemCacheImplTest {
  private InMemCacheImpl inMemCache;

  /**
   * Sets up.
   */
  @BeforeEach
   void setUp() {
    inMemCache = new InMemCacheImpl();
  }

  /**
   * Test put.
   */
  @Test
  void testPut() {
    String key = "key";
    Object value = "value";

    inMemCache.put(key, value);
    assertEquals(value, inMemCache.get(key));
  }

  /**
   * Test get.
   */
  @Test
  void testGet() {
    String key = "key";
    Object value = "value";

    inMemCache.put(key, value);

    assertEquals(value, inMemCache.get(key));
    assertNull(inMemCache.get("non-existent-key"));
  }

  /**
   * Test evict.
   */
  @Test
  void testEvict() {
    String key = "key";
    Object value = "value";

    inMemCache.put(key, value);

    inMemCache.evict(key);

    assertNull(inMemCache.get(key));
  }

  @Test
  void testClear() {
    String key1 = "key1";
    String key2 = "key2";
    Object value1 = "value1";
    Object value2 = "value2";

    inMemCache.put(key1, value1);
    inMemCache.put(key2, value2);

    inMemCache.clear();

    assertNull(inMemCache.get(key1));
    assertNull(inMemCache.get(key2));
  }
}
