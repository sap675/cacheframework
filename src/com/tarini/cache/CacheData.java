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

/**
 * This Interface defines the holder for the data, user needs to implement 
 * this interface to use the cache. 
 * 
 * The Interface provides a type which can be used to define the data type when,
 * implementing the interface.
 * 
 * @author suman
 *
 * @param <T> The data type of the data being represented.
 */
public interface CacheData<T> {

    /**
     * Returns the data.
     * @return T
     */
    public T getData();
    
    /**
     * Returns value greater than zero if data needs to fetched, else
     * it returns a value less than or equal to zero.
     *
     * @return the refresh timeout
     */
    public long getRefreshTimeout();
    
}
