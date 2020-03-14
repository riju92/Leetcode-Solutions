/*
283. Move Zeroes
Easy

3016

102

Add to List

Share
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

class Solution {
    public void moveZeroes(int[] nums) 
    {
        int[] result = new int[nums.length];
        int count = 0;
        int t = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
               count++;
            }
            else
            {
                result[t] = nums[i];
                t++;
            }
        }
        while( count > 0)
        {
            result[t] = 0;
            t++;
            count--;
        }
        for(int i = 0; i < result.length; i++)
        {
            nums[i] = result[i];
        }
    }
}