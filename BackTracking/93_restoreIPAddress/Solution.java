/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

class Solution
{
	public List<String> restoreIPAddresses(String s)
	{
		List<String> result = new ArrayList<>();
		helper(result, s, 0, "", 0);
		return result;
	}

	public void helper(List<String> result, String s, int index, String current, int count)
	{
		if(count > 4) return;
		if(count == 4 && s.length() == index) result.add(current);

		for(int i = 1; i <= 4; i++)
		{
			if(index + i > s.length) break;
			String temp = s.substring(index, index + i);
			if((temp.charAt(0) == '0' && temp.length() > 1) || (Integer.parseInt(temp) > 255 && i == 3)) continue;
			helper(result, s, index + i, current + temp + (count == 3? "" : "."), count + 1);
		}
	}
}
