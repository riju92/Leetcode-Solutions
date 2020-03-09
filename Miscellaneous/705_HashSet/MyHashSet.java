/*
705. Design HashSet
Easy

237

61

Add to List

Share
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
*/

/*
705. Design HashSet
Easy

237

61

Add to List

Share
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
*/

class MyHashSet {
    
    boolean[] a = new boolean[100];

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        
        if(key >= a.length)
            extend(key);
        
        a[key] = true;
        
    }
    
    public void remove(int key) {
        
        if(key >= a.length)
            extend(key);
        
        a[key] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        if(key >= a.length)
            return false;
        
        return a[key] == true;
        
    }
    
    public void extend(int key)
    {
        a = Arrays.copyOf(a, key + 2);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */