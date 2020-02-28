/*
647. Palindromic Substrings
Medium

2013

98

Add to List

Share
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

class Solution {
    public int countSubstrings(String s) 
    {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        
        for(int i = s.length() - 1 ; i>= 0; i--)
        {
            for(int j = i; j < s.length(); j++)
            {
                dp[i][j]=((s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]));
                
                if(dp[i][j]) res++;
                
            }
        }
        return res;
    }
}