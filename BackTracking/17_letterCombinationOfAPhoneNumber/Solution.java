/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

class Solution
{
	public List<String> letterCombinations(String digits)
	{
		List<String> result = new ArrayList<>();

		if(digits == null || digits.length() == 0) return result;

		String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		helper(digits, result, "", 0, mapping);
		return result;
	}

	public void helper(String digits, List<String> result, String current, int index, String[] mapping)
	{
		if(index == digits.length())
		{
			result.add(current);
			return;
		}

		String letters = mapping[digits.charAt(index) - '0'];

		for(int i = 0; i < letters.length(); i++)
		{
			helper(digits, result, current + letter.charAt(i), index + 1, mapping);
		}
	}
}
