/*
 * 1060. Missing Element in Sorted Array
Medium

615

30

Add to List

Share
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.



Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation:
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation:
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation:
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
*/

class Solution
{
	public int missingElement(int[] nums, int k)
	{
		int noMissingElements = calculate(nums, nums.length - 1);
		if(noMissingElements < k)
			return (nums[nums.length - 1] + k - noMissingElements);

		int left = 0, right = nums.length - 1;

		while(left < right)
		{
			int mid = left + (right - left) / 2;
			noMissingElements = calculate(nums, mid);

			if(noMissingElements >= k)
				right = mid;
			else
				left = mid + 1;
		}
		left--;
		return (nums[left] + k - calculate(nums, left));
	}

	private int calculate(int[] nums, int size)
	{
		return (nums[size] - nums[0] - size);
	}
}
