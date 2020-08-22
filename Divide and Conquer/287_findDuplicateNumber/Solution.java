/*
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
*/

class Solution
{
	public int findDuplicate(int[] nums)
	{
		int left = 1;
		int right = nums.length - 1;

		while(left < right)
		{
			int count = 0;
			int mid = left + (right - left) / 2;
			for(int i : nums)
			{
				if(i <= mid)
					count++;
			}

			if(count <= mid)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}
