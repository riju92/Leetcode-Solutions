/*
146. LRU Cache
Medium

5400

243

Add to List

Share
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/


import java.util.LinkedHashMap;
class LRUCache 
{
    
    int capacity = 0;
    LinkedHashMap<Integer, Integer> lruCmap;

    public LRUCache(int capacity) 
    {
        
        this.capacity = capacity;
        lruCmap = new LinkedHashMap<>();
        
    }
    
    public int get(int key) 
    {
        Integer val = lruCmap.get(key);
        if(val != null)
        {
            lruCmap.remove(key);
            lruCmap.put(key, val);
            return val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) 
    {
       if(lruCmap.size() == capacity)
       {
           if(!lruCmap.containsKey(key))
           {
               int t = lruCmap.entrySet().iterator().next().getKey();
               lruCmap.remove(t);
               
           }
           else
           {
               lruCmap.remove(key);
               
           }
           lruCmap.put(key, value);
       }
        else
        {
            if(lruCmap.containsKey(key))
            {
                lruCmap.remove(key);
            }
            lruCmap.put(key , value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */