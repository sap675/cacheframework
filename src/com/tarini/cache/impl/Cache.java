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

/**
 * The Interface Cache. This exposes the basic functions of a the cache
 * to the user. 
 *
 * @param <T> the generic type
 */
public interface Cache<T> {

    /**
     * Initialize the cache. This method must be invoke
     * before calling insert or get operations on Cache.
     *
     * @param type the type
     */
    public void initCache(T type);
    
    
    /**
     * Insert, the data into the cache, this will return an key
     * that needs to be maintained to get the data. 
     * 
     * This key needs to be unique a suggested approach is to use
     * {@link java.util.UUID#randomUUID()}.
     * If you need caching for large data sets a different approach 
     * needs to be used since above method may not produce a unique key
     * @see java.util.UUID
     *
     * @param data the data type
     * @return the unique key used to map the data.
     */
    public String insert(T data);
    
    /**
     * Gets the data from the Cache, if the given key is not present in the
     * cache it will return null.
     *
     * @param key the key used in the cache.
     * @return the data if key is found else NULL.
     */
    public T getData(String key);
}
