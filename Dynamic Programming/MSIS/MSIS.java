/*
Maximum Sum Increasing Subsequence | DP-14
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such 
that the integers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5},
then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
and if the input array is {10, 5, 4, 3}, then output should be 10
*/

class MSIS
{
    public static void main(String[] args)
    {
        MSIS test = new MSIS();
        int[] arr = {1,101,10,2,3,100,4};
        System.out.println("The maximum increasing subsequence sum is:" + test.MSIS(arr));
    }

    public int MSIS(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            dp[i] = nums[i];
        }

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j] )
                {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}