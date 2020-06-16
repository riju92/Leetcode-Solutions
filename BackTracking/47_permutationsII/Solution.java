/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution
{
	public List<List<Integer>> permutations(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		helper(result, nums, new ArrayList<>(), new boolean[nums.length]);
		return result;
	}
	public void helper(List<List<Integer>> result, int[] nums, List<Integer> current, boolean[] used)
	{
		if(nums.length == current.size()) 
		{
			result.add(new ArrayList<>(current));
		}
		else
		{
			for(int i = 0; i < nums.length; i++)
			{
				if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue; //ignoring duplicates
				used[i] = true;
				current.add(nums[i]);
				helper(result, nums, current, used);
				used[i] = false;
				current.remove(current.size() - 1);
			}
		}
		
	}
}

