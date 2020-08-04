/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
*/

class Solution
{
	public int findKthLargest(int[] nums, int k)
	{
		k = nums.length - k;
		int low = 0, high = nums.length - 1;
		while(low < high)
		{
			int mid = partition(nums, low, high);
			if(mid < k)
				low = mid + 1;
			else if (mid > k)
				high = mid - 1;
			else
				break;
		}
		return nums[k];
	}

	public boolean compare(int a, int b)
	{
		return a < b;
	}
	public void exchange(int[] nums, int a , int b)
	{
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public int partition(int[] nums, int low, int high)
	{
		int left = low;
		int right = high + 1;
		while(true)
		{
			while(left < high && compare(nums[++left], nums[low]));
			while(low < right && compare(nums[low], nums[--right]));
			if(left >= right)
				break;
			exchange(nums, left, right);
		}
		exchange(nums, low, right);
		return right;
	}
}
