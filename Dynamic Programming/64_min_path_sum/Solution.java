/*
64. Minimum Path Sum
Medium

2106

48

Add to List

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

class Solution {
    public int minPathSum(int[][] grid) 
    {
        if(grid == null || grid.length == 0) return 0;
        
        int[][] sum = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                sum[i][j] += grid[i][j];
                if( i > 0 && j > 0) sum[i][j] += Math.min(sum[i - 1][j] , sum[i][j - 1]);
                else if ( i > 0 && j == 0)  sum[i][j] += sum[i - 1][j];
                else if ( i == 0 && j > 0)  sum[i][j] += sum[i][j - 1];
                
            }
        }
       return sum[sum.length -1][ sum[0].length -1]; 
    }
}