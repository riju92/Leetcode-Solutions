/*
1335. Minimum Difficulty of a Job Schedule
Hard

212

5

Add to List

Share
You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.

Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
*/

class Solution
{
    public int minDifficulty(int[] jobDifficulty, int d)
    {
        int[][] dp = new int[d][jobDifficulty.length];
        dp[0][0] = jobDifficulty[0];

        if(jobDifficulty.length < d)
            return -1;

        for(int i = 1; i < jobDifficulty.length; i++)
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);

        for(int i = 1; i < d; i++)
        {
            for(int j = i; j < jobDifficulty.length; j++)
            {
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
                for(int r = j; r >= i; r--)
                {
                    localMax = Math.max(localMax, jobDifficulty[r]);
                    dp[i][j] = Math.min(dp[i][j], localMax + dp[i -1][r - 1]);
                }
            }
        }

        return dp[d - 1][jobDifficulty.length - 1];
    }
}