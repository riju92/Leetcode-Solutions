/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
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
			if(i > index && nums[i] == nums[i - 1]) continue; //remove duplicates
			current.add(nums[i]);
			helper(result, nums, current, i + 1);
			current.remove(current.size() - 1);
		}
	}	
}
