/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    public int majorityElement(int[] nums) {
        
        return majorityElementRec(nums,0,nums.length-1);
    }
    
    private int majorityElementRec(int[] nums,int lo,int hi)
    {
        if (lo == hi)
            return nums[lo];
        
        int mid = (hi - lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);
        
        if( left == right)
            return left;
        
        int left_count = countInRange(nums, left, lo, hi);
        int right_count = countInRange(nums, right, lo, hi);
        
        return left_count > right_count ? left : right;
        
    }
    
    private int countInRange(int[] nums, int n , int lo,int hi)
    {
        int count = 0;
        for (int i = lo; i<=hi; i++)
        {
            if(nums[i] == n)
                count+= 1;
        }
        return count;
    }
}
