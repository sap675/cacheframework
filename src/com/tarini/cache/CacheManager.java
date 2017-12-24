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
package com.tarini.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This class represents the basic LRU Cache functions
 * using the <code>CacheData</code> interface as an holder
 * for data. 
 * 
 * This class uses the default implementation for the <code>CacheData</code>
 * interface where the default time out is 0.
 *
 * @author suman
 * @param <T> the generic type
 */
public class CacheManager<T> {

    /** The Constant DEFAULT_CACHE_SIZE. */
    private static final int DEFAULT_CACHE_SIZE = 20;
    
    /** The cache holder. */
    private Map<String, CacheData<T>> cacheHolder;
    
    /** The lru queue. */
    private LinkedList<String> lruQueue;
    
    /** The cache size. */
    private int cacheSize = DEFAULT_CACHE_SIZE;
    
    /**
     * Instantiates a new cache manager.
     */
    public CacheManager() {
        cacheHolder = new HashMap<String, CacheData<T>>();
        lruQueue = new LinkedList<String>();
    }
    
    /**
     * Gets the data from the Cache or Null if there is no data.
     *
     * @param key the key that was used to map the data.
     * @return the data <code>Object</code> or NULL 
     */
    public T getData(String key) {
        CacheData<T> data = null;
        if(lruQueue.isEmpty() || !lruQueue.contains(key)) {
            data = null;
        } else if(lruQueue.peek().equals(key)) {            
            data = cacheHolder.get(key);
        } else if(!lruQueue.peek().equals(key) && lruQueue.contains(key)) {
            data = cacheHolder.get(key);
            lruQueue.remove(key);
            lruQueue.addFirst(key);
        }
        return data.getData();
    }
    
    /**
     * Insert data into cache using the actual data, this method 
     * uses the default implementation of <code>CacheData<T></code> 
     * interface.
     *
     * @param key the key used map the data object.
     * @param data the data that needs to be stored in the cache.
     */
    public void insert(String key, T data) {
        if(!lruQueue.contains(key)) {
            if(lruQueue.size() == cacheSize) {
                String lruKey = lruQueue.removeLast();
                cacheHolder.remove(lruKey);
                lruQueue.addFirst(key);
                cacheHolder.put(key, new CacheDataImpl<T>(data));
            }
        }
    }
    
    /**
     * Sets the cache size.
     *
     * @param size the new cache size
     */
    public void setCacheSize(int size) {
        if(size > 0) {
            this.cacheSize = size;
        } else {
            cacheSize = DEFAULT_CACHE_SIZE;
        }
    }
    
    /**
     * This is an overloaded insert method to insert data into cache
     * which hold the custom implementation of the <code>CacheData<T><code>
     * interface.
     * 
     *
     * @param key the key
     * @param data the data
     */
    public void insert(String key, CacheData<T> data) {
        synchronized(this) {
            insert(key, data.getData());
        }
    }
}

/**
 * This is the default implementation for the <code>CacheData<T></code>
 * interface. By default this class assumes that there is no timeout for the 
 * CacheData. If user need a specific time to refresh the data the implementation
 * needs to be provided by the user.
 *
 * @author suman
 * @param <T> the generic type
 */
class CacheDataImpl<T> implements CacheData<T> {

    private T data;
    
    /**
     * Instantiates a new cache data impl.
     *
     * @param data the data
     */
    public CacheDataImpl(T data) {
        this .data = data;
    }
    
    @Override
    public T getData() {
        return data;
    }

    @Override
    public long getRefreshTimeout() {
        return 0;
    }
}
