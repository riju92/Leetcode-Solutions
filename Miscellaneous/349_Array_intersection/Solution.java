/*
349. Intersection of Two Arrays
Easy

623

1043

Add to List

Share
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        HashSet<Integer> s1 = new HashSet<Integer>();
        HashSet<Integer> s2 = new HashSet<Integer>();
        
        for(int i : nums1)
        {
            s1.add(i);
        }
        
        for(int i : nums2)
        {
            s2.add(i);
        }
        
        s1.retainAll(s2);
        int[] out = new int[s1.size()];
        
        int index = 0;
        for (int i: s1)
        {
            out[index] = i;
            index++;
        }
        return out;
    }
}