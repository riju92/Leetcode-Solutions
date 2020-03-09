/*
151. Reverse Words in a String
Medium

844

2653

Add to List

Share
Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

class Solution {
    public String reverseWords(String s) 
    {
        if(s == null) return null;
        char[] a = s.toCharArray();
        
        int n = a.length;
        
        reverse(a , 0 , n - 1);
        
        reverseWords(a , n);
        
        return cleanSpaces(a , n);
    }
    
    private void reverse(char[] a, int i, int j)
    {
        while(i < j)
        {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
    
    public void reverseWords(char[] a , int n)
    {
        int i = 0;
        int j = 0;
        
        while(i < n)
        {
            while(i < j || i < n && a[i] == ' ') i++;
            while(j < i || j < n && a[j] != ' ') j++;
            reverse(a, i, j - 1);
        }
    }
    
    public String cleanSpaces(char[] a, int n)
    {
        int i = 0;
        int j = 0;
        while(j < n)
        {
            while(j < n && a[j] == ' ') j++;
            while(j < n && a[j] != ' ') a[i++] = a[j++];
            while(j < n && a[j] == ' ') j++;
            if(j < n) a[i++] = ' ';
        }
        
        return new String(a).substring(0 , i);
    }
}