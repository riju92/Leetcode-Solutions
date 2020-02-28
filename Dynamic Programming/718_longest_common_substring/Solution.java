/*
718. Maximum Length of Repeated Subarray
Medium

951

40

Add to List

Share
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
*/

class Solution {
    public int findLength(int[] A, int[] B) 
    {
        int[][] dp = new int[A.length + 1][B.length + 1];
        
        int length = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < B.length; j++)
            {
                if(A[i] == B[j])
                {
                    dp[i + 1][j + 1] = 1 + dp[i][j]; 
                }
                
                if(length < dp[i + 1][j + 1])
                {
                    length = dp[i + 1][j + 1];
                }
            }
        }
        return length;
    }
}