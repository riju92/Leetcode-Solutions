/*
5. Longest Palindromic Substring
Medium

5499

469

Add to List

Share
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
*/

class Solution {
    
    public String longestPalindrome(String s) 
    {
        if(s.equals("")) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String r = null;
        
        for(int i = s.length() - 1; i >= 0; i--)
        {
            for(int j = i; j < s.length(); j++)
            {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
            
            
                if(dp[i][j] &&  (r == null || j - i + 1 > r.length()))
                {
                    r = s.substring(i, j + 1);
                }
            }
                       
        }
        return r;
        
    }

}