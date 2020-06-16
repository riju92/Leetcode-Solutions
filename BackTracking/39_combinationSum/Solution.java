/*
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
  */

class Solution
{
	public List<List<Integer>> combinationSum(int[] nums, int target)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort();
		helper(result, nums, new ArrayList<>(), target, 0);
		return result;
	}
	public void helper(List<List<Integer>> result, int[] nums, List<Integer> current, int target, int index)
	{
		if(target < 0) return;
		if(target == 0) result.add(new ArrayList<>(current));

		for(int i = index; i < nums.length; i++)
		{
			current.add(nums[i]);
			helper(result, nums, current, target - nums[i], i);
			current.remove(current.size() - 1);
		}
	}
}
