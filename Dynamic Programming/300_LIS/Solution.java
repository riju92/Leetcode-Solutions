/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
*/

class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        if(nums.length == 0) return 0;
        int max =1;
        int[] max_length = new int[nums.length];
        Arrays.fill(max_length , 1);
        
        for(int i = 1; i<nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                
                if (nums[i] > nums[j]) max_length[i] = Math.max(max_length[i], 1 + max_length[j]);
            }
            max = Math.max(max_length[i], max);
        }
        return max;
    }
}
