/*
3. Longest Substring Without Repeating Characters
Medium

7993

487

Add to List

Share
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if (s.length() == 0) return 0;
        
        char[] s_arr = s.toCharArray();
        HashSet<Character> Set = new HashSet<>();
        
        int i = 0;
        int j = 0;
        int length = Math.abs(i - j);
        
        while(i < s_arr.length)
        {
            if(Set.contains(s_arr[i]))
            {
                while(s_arr[i] != s_arr[j])
                {
                    Set.remove(s_arr[j]);
                    j++;
                }
                j++;
                
            }
            else
            {
                Set.add(s_arr[i]);
            }
            
            length = Math.max(length , Math.abs(i - j));
            i++;
        }
        return length + 1;
        
    }
}