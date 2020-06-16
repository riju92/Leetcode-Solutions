/*Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution
{
	public List<List<Integer>> permutation(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();

		helper(result, nums, new ArrayList<>());
		return result;
	}
	public void helper(List<List<Integer>> result, int[] nums, List<Integer> current)
	{
		if(nums.length == current.size()) current.add(new ArrayList<>(current));

		for(int i = 0; i < nums.length; i++)
		{
			if(current.contains(nums[i])) continue; //element already present
			current.add(nums[i]);
			helper(result, nums, current);
			current.remove(current.size() - 1);
		}
	}
}
