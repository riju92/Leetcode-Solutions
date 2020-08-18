/*
364. Nested List Weight Sum II
Medium

476

123

Add to List

Share
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {
    
    HashMap<Integer , HashMap<Integer , Integer>> map;
    int max_depth = Integer.MIN_VALUE;
    
    public int depthSumInverse(List<NestedInteger> nestedList) 
    {
        map = new HashMap<>();
        
        for(NestedInteger i : nestedList)
        {
            dfs(i , 0);
        }
        
        int sum = 0;
        
        for(Map.Entry<Integer , HashMap<Integer , Integer>> depth : map.entrySet())
        {
            for(Map.Entry<Integer , Integer> Integer : depth.getValue().entrySet())
            {
                sum += (max_depth - depth.getKey() + 1) * Integer.getKey() * Integer.getValue(); 
            }
        }
        return sum;
        
    }
    
    public void dfs(NestedInteger nested_int , int depth)
    {
        if(nested_int.isInteger())
        {
            max_depth = Math.max(depth , max_depth);
            map.putIfAbsent(depth , new HashMap<>());
            map.get(depth).put(nested_int.getInteger() , map.get(depth).getOrDefault(nested_int.getInteger(), 0) + 1);
            return;
        }
        
        for(NestedInteger i : nested_int.getList())
            dfs(i , depth + 1);
    }
}