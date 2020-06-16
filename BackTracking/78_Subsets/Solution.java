/*
 Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution
{
	public List<List<Integer>> subsets(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		helper(result, nums, new ArrayList<>(), 0);
		return result;
	}
	public void helper(List<List<Integer>> result, int[] nums, List<Integer> current, int index)
	{
		 result.add(new ArrayList<>(current));

		for(int i = index; i < nums.length; i++)
		{
			current.add(nums[i]);
			helper(result, nums, current, i + 1);
			current.remove(curren.size() - 1);
		}
	}
}
