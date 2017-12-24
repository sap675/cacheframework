/***************************************************************************************
 * This software is Copyright (C) 2017 by Suman Mummaneni 
 * This software is licensed under LGPL License agreement 
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 ***************************************************************************************/
package com.tarini.cache.impl;

import java.util.UUID;

import com.tarini.cache.CacheManager;

/**
 * The Class LRUCache. Implements the {@code Cache<T>} interface.
 * This internally uses an LRU based caching and only takes the 
 * actual data. This implementation does not support {@code CacheData<T>}
 * interface.
 * 
 *
 * @param <T> the generic type
 */
class LRUCache<T> implements Cache<T> {

    /** The LRU Cache manager. */
    private CacheManager<T> lruMgr;
    
    /** The lock object. */
    private Object lock = new Object();
    
    /**
     * Instantiates a new LRU cache.
     */
    LRUCache(){
    }
    
    /**
     * @see com.tarini.cache.impl.Cache#initCache
     */
    @Override
    public void initCache(T type) {
        lruMgr = new CacheManager<T>();
    }

    /**
     * Initializes the cache. An overloaded method that
     * is provided for the user to support the initialize 
     * size of the cache that needs to be used.
     *
     * @param type the data type being stored. 
     * @param size the initial size must be a non zero positive integer.
     */
    public void initCache(T type, int size) {
        initCache(type);
        lruMgr.setCacheSize(size);
    }

    /**
     * @see com.tarini.cache.impl.Cache#insert
     * 
     */
    @Override
    public String insert(T data) {
        String key = null;
        synchronized(lock) {
            UUID uuidKey = UUID.randomUUID();
            key = uuidKey.toString();
            lruMgr.insert(key, data);
        }
        return key;
    }

    /**
     * @see com.tarini.cache.impl.Cache#getData
     */
    @Override
    public T getData(String key) {
        T data = null;
        synchronized(lock) {
            data = lruMgr.getData(key);
        }
        return data;
    }
}
