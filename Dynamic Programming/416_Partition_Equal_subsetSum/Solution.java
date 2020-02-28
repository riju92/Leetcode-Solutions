/*
416. Partition Equal Subset Sum
Medium

1920

56

Add to List

Share
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

class Solution {
    public boolean canPartition(int[] nums) 
    {
        int target = 0;
        for(int i : nums)
        {
            target += i;
        }
        if((target & 1) == 1)
        {
            return false;
        }
        
        
        target = target >> 1;
        
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        
        // for(int i = 1; i < nums.length; i++)
        // {
        //     dp[i][0] = true;
        // }
        
        for(int i = 1; i < nums.length + 1; i ++)
        {
            for(int j = 1; j < target + 1; j++)
            {
                if(j < nums[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
                
            }
        }
        return dp[nums.length][target];
    }
}