/*
Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.

Don't include the first or final entry. You can only move either down or right at any point in time.

Example 1:

Input:
[[5, 1],
 [4, 5]]

Output: 4
Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.
Example 2:

Input:
[[1, 2, 3]
 [4, 5, 1]]

Output: 4
Explanation:
Possible paths:
1-> 2 -> 3 -> 1
1-> 2 -> 5 -> 1
1-> 4 -> 5 -> 1
So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
Return the max of that, so 4.

*/
// Define: dp[i][j] is the max score from [0][0] to [i][j]
  // Recurence Formula: dp[i][j] = max( min(dp[i-1][j], grid[i][j]), min(dp[i][j-1]), grid[i][j] )
  // Note: Init the first entry as Integer.MAX_VALUE
  
  // DP (2D)
  // Time: O(rc) Space: O(rc)


class Solution
{
    public static int maxScore2D(int[][] grid)
    {
        // Assume there is at least one element
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = Integer.MAX_VALUE; // ignore first entry
        
        for(int r = 1; r < grid.length; r++)
            dp[r][0] = Math.min(dp[r][0], dp[r -1][0]);

        for(int c = 1; c < grid[0].length; c++)
            dp[0][c] = Math.min(dp[0][c], dp[0][c - 1]);

        for(int r = 1; r < grid.length; r++)
        {
            for(int c = 1; c < grid[0].length; c++)
            {
                if(r == grid.length - 1 && c == grid[r].length - 1)
                    dp[r][c] = Math.max(grid[r - 1][c], grid[r][c - 1]); // last entry is not considered
                else
                {
                    int temp1 = Math.min(dp[r][c], dp[r - 1][c]); // up
                    int temp2 = Math.min(dp[r][c], dp[r][c - 1]); // left
                    dp[r][c] = Math.max(temp1, temp2);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {
            int[][] grid1 = new int[][] { {5, 1}, {4, 5} };                        // 4
            int[][] grid2 = new int[][] { {5, 1, 7}, {4, 8, 5} };                  // 4
            int[][] grid3 = new int[][] { {1, 9, 9}, {9, 9, 9}, {9, 9, 9} };       // 1 (if the first entry is not considered)
            int[][] grid4 = new int[][] { {10, 7, 3}, {12, 11, 9}, {1, 2, 8} };    // 8 (same reason)
            int[][] grid5 = new int[][] { {20, 20, 3}, {20, 3, 20}, {3, 20, 20} }; // 3
            System.out.println("grid1: Expected: 4, Actual: " + maxScore2D(grid1));
            System.out.println("grid2: Expected: 4, Actual: " + maxScore2D(grid2));
            System.out.println("grid3: Expected: 1, Actual: " + maxScore2D(grid3) + " (if the first entry is not considered)");
            System.out.println("grid4: Expected: 8, Actual: " + maxScore2D(grid4) + " (same reason)");
            System.out.println("grid5: Expected: 3, Actual: " + maxScore2D(grid5));
          }
          
    
}