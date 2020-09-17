/*
680. Valid Palindrome II
Easy

1861

118

Add to List

Share
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
*/

class Solution
{
    public boolean validPalindrome(String s)
    {
        int left = 0; int right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
                return isPalin(s, left + 1, right) || isPalin(s, left, right - 1);
            
            left++; right--;
        }
        return true;
    }

    public boolean isPalin(String s, int i, int j)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}