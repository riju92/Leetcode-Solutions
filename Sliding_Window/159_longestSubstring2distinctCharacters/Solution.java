/*
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

class Solution
{
	public int lengthOfLongestSubstringTwoDistinct(String s)
	{
		HashMap<Character, Integer> map = new HashMap<>();

		if(s == null || s.length() == 0) return 0;
		int left = 0, right = 0, counter = 0, result = 0;

		while(right < s.length())
		{
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if(map.get(c) == 1) counter++;

			if(counter > 2)
			{
				char t = s.charAt(left);
				map.put(t, map.getOrDefault(t, 0) - 1);
				if(map.get(t) == 0) counter--;
				left++;
			}

			right++;
			result = Math.max(result, Math.abs(left - right));
		}
		return result;

	}
}
