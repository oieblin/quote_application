package com.ccufs.quote_application.cache;


import org.springframework.stereotype.Service;

@Service
public class InMemCacheService {

    private final InMemCache inMemCache;

    public InMemCacheService(InMemCache inMemCache) {
        this.inMemCache = inMemCache;
    }

    public void addToCache(String key, Object value) {
        inMemCache.put(key, value);
    }

    public Object getFromCache(String key) {
        return inMemCache.get(key);
    }

    public void removeFromCache(String key) {
        inMemCache.evict(key);
    }

    public void clearCache() {
        inMemCache.clear();
    }

    public boolean ifCacheKeyExists(String key) {
        return inMemCache.containsKey(key);
    }

    public boolean ifCacheValueExists(String key, Object value) {
        return inMemCache.containsKey(key) && inMemCache.get(key).equals(value);
    }
}
