/*
120. Triangle
Medium

1573

187

Add to List

Share
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int c = triangle.get(triangle.size() - 1).size();
        int r = triangle.size();
        int[][] dp = new int[r][c];
        
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i = 1; i < r; i++)
        {
            for(int j = 0; j <=i; j++)
            {
                if(j == 0)
                {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else if (j == i)
                {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                else
                {
                    dp[i][j] = Math.min(triangle.get(i).get(j) + dp[i - 1][j - 1],triangle.get(i).get(j) + dp[i - 1][j]); 
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < c; k++)
        {
            if(dp[r - 1][k] < min) 
            {
                min = dp[r - 1][k];
            }
        }
        return min;
        //return dp[r -1][1]; 
    }
}