/*
115. Distinct Subsequences
Hard

1469

59

Add to List

Share
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
    */

class Solution
{
    public int numDistinct(String s, String t)
    {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // filling the first row: with 1s
        // the first row must be filled with 1. 
        // That's because the empty string is a subsequence of any string but only 1 time. 
        // So mem[0][j] = 1 for every j. So with this we not only make our lives easier, but we also return correct value if T is an empty string.

        for(int i = 0; i < s.length(); i++)
            dp[0][i] = 1;

        // the first column of every rows except the first must be 0. 
        // This is because an empty string cannot contain a non-empty string as a substring -- 
        //      the very first item of the array: mem[0][0] = 1, because an empty string contains the empty string 1 time.
        // the first column is 0 by default in every other rows but the first, which we need.
        
        for(int r = 0; r < t.length(); r++)
        {
            for(int c = 0; c < s.length(); c++)
            {
                if(s.charAt(c) == t.charAt(r))
                    dp[r+1][c+1] = dp[r][c] + dp[r+1][c];
                else
                    dp[r+1][c+1] = dp[r+1][c];
            }
        }

        return dp[t.length()][s.length()];
    }
}