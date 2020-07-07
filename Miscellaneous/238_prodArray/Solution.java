/*
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
*/

class Solution
{
	public int[] productExceptSelf(int[] nums)
	{
		int length = nums.length;
		int[] result = new int[length];
		result[0] = 1;
		for(int i = 1; i < length; i++)
		{
			result[i] = result[i - 1] * nums[i - 1]; 
		}
		int prod = 1;
		for(int i = length - 1; i >= 0; i--)
		{
			result[i] *= prod;
			prod *= nums[i];
		}
		return result;
	}
}
