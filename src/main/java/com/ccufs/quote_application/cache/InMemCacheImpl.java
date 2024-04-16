package com.ccufs.quote_application.cache;


import org.springframework.stereotype.Component;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemCacheImpl implements InMemCache{

    private final Map<String,Object> cache = new ConcurrentHashMap<>();

    @Override
    public void put(String key, Object value){
        cache.put(key,value);
    }

    @Override
    public Object get(String key){
        return cache.get(key);
    }

    @Override
    public void evict(String key){
        cache.remove(key);
    }

    @Override
    public  void clear(){
        cache.clear();
    }

    @Override
    public boolean containsKey(String key){
        return cache.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value){
        return cache.containsValue(value);
    }
}
