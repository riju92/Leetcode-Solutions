/*
 * 387. First Unique Character in a String
Easy

1915

116

Add to List

Share
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2
*/

class Solution
{
	public int firstUniqChar(String s)
	{
		int[] freq = new int[26];
		for(int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;

		for(int i = 0; i < s.length(); i++)
		{
			if(freq[s.charAt(i) - 'a'] == 1) return i;
		}
		return -1;
	}
}
