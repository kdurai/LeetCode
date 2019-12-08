package com.leetcode.medium.dec201908;

import java.util.LinkedHashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); // capacity ;

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 * 
 */

public class LRUCache {
	
	private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
	private int cap;
	
	 public LRUCache(int capacity) {
		 this.cap = capcity;
	 }
	    
	public int get(int key) {
	        if(cache.containsKey(key))
	        {
	        	int value = cache.get(key);
	        	cache.remove(key);
	        	cache.put(key,  value);
	        	return value;
	        }
	        
	        return -1;
	    }
	    
	public void put(int key, int value) {
	        if(cache.containsKey(key))
	        {
	        	cache.remove(key);
	        	cache.put(key, value);
	        }
	        else
	        	if(cap == cache.size()) cache.remove(cache.entrySet().iterator().next().getKey());
	        
	        cache.put(key, value);
	    }
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(10);
		
	}

}
