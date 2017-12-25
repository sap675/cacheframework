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
 * A factory for creating C objects.
 */
public class CFactory implements CacheFactory {

    /** The instance. */
    private static CFactory instance;
    
    /**
     * Instantiates a new c factory.
     */
    private CFactory() {
    }
    
    /**
     * Gets the single instance of CFactory.
     *
     * @return single instance of CFactory
     */
    public static CFactory getInstance() {
        if(instance == null) {
            synchronized(CFactory.class) {
                instance = new CFactory();
            }
        }
        return instance;
    }
    
    
    /**
     * @see com.tarini.cache.impl.CacheFactory#getLRUCache(java.lang.Class)
     */
    @Override
    public <E> Cache<E> getLRUCache(E type) {
        Cache<E> cache = new LRUCache<>();
        return cache;
    }

}
