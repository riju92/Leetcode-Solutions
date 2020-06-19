/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution
{
	public String minWindow(String s, String t)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray())
		{
			map.put(c, 0);
		}
		for(char c : t.toCharArray())
		{
			if(map.containsKey(c)) map.put(c, map.get(c) + 1);
			else
				return "";
		}

		int start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0, count = t.length();
		
		while(end < s.length())
		{
			char c1 = s.charAt(end);
			if(map.get(c1) > 0) count--;
			map.put(c1, map.get(c1) - 1);
			end++;

			while(count == 0)
			{
				if(minLen > end - start)
				{
					minLen = end - start;
					minStart = start;
				}
				
				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);

				if(map.get(c2) > 0) count++;

				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}
}
