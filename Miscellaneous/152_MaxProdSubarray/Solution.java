/*
152. Maximum Product Subarray
Medium

3226

135

Add to List

Share
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) 
    {
        if(nums == null) return -1;
        int curr_max = nums[0];
        int curr_min = nums[0];
        int final_max = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            int temp = curr_max;
            curr_max = Math.max(Math.max(curr_max * nums[i] , curr_min * nums[i]) , nums[i]);
            curr_min = Math.min(Math.min(temp * nums[i] , curr_min * nums[i]) , nums[i]);
            
            if(curr_max > final_max)
            {
                final_max = curr_max;
            }
        }
        return final_max;
    }
}