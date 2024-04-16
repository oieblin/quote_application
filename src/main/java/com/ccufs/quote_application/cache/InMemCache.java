package com.ccufs.quote_application.cache;

public interface InMemCache {
    void put(String key, Object value);
    Object get(String key);
    void evict(String key);
    void clear();
    boolean containsKey(String key);
    boolean containsValue(Object value);
}
