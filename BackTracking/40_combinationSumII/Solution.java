/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
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
		if(target < 0 ) continue;
		if(target == 0) result.add(new ArrayList<>(current));
		for(int i = index; i < nums.length; i++)
		{
			if(i > index && nums[i - 1] == nums[i]) continue; //avoiding duplicates
			current.add(nums[i]);
			helper(result, nums, current, target - nums[i], i + 1);
			current.remove(current.size() - 1);
		}
	}
}
