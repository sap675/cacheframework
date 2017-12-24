package com.tarini.cache.impl;

public class CFactory implements CacheFactory {

    private static CFactory instance;
    
    private CFactory() {
    }
    
    public static CFactory getInstance() {
        if(instance == null) {
            synchronized(CFactory.class) {
                instance = new CFactory();
            }
        }
        return instance;
    }
    
    
    @Override
    public Cache<?> getLRUCache(Class<?> t) {
        //TODO: Fix this code needs to look at it.
        LRUCache<?> cache = new LRUCache<>();
        return cache;
    }

}
