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

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Cache objects.
 */
public interface CacheFactory {

    
    /**
     * Gets the LRU cache.
     *
     * @param <E> the element type
     * @param type the data type
     * @return the LRU cache
     */
    public <E> Cache<E> getLRUCache(E type);
    
}
