/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> result = new ArrayList<>();
		palindrome(result, s, new ArrayList<>(), 0);
		return result;
	}
	public void palindrome(List<List<String>> result, String s, List<String> temp, int index)
	{
		if(index = s.length()) result.add(new ArrayList<>(temp));
		else
		{
			for(int i = index; i < s.length(); i++)
			{
				if(isPalindrome(s, index, i))
				{
					temp.add(s.substring(index, i + 1));
					palindrome(result, s, temp, i + 1);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
	public boolean isPalindrome(String s, int low, int high)
	{
		while(low < high)
		{
			if(s.charAt(low++) != s.charAt(high--)) return false;
		}
		return true;
	}
}

