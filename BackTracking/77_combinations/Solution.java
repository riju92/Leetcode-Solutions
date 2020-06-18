/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution
{
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<>(), 1, n, k);
		return result;
	}
	public void helper(List<List<Integer>> result, String<Integer> current, int start, int n, int k)
	{
		if(k == 0) result.add(new ArrayList<>(current));

		for(int i = start; i <= n; i++)
		{
			current.add(i);
			helper(result, current, i + 1, n, k - 1);
			current.remove(current.size() - 1);

		}
	}
}
