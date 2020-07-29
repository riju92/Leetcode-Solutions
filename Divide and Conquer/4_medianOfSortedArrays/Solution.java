/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

class Solution
{
	public double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
		int m = nums1.length, n = nums2.length;
		boolean isEven = ((m + n) % 2 == 0);
		if(m > n)
			return findMedian(nums1, nums2, isEven);
		else
			return findMedian(nums2, nums1, isEven);
	}

	public double findMedian(int[] longArr, int[] shortArr, boolean isEven)
	{
		int m = shortArr.length;
		int n = longArr.length;
		int imin = 0;
		int imax = m;
		double right_min;
		double left_max;
		while(imin <= imax)
		{
			int i = (imax + imin) / 2;
			int j = (m + n) / 2 - i;

			if(i < m && longArr[j - 1] > shortArr[i])
				imax = i + 1;
			else if(i > 0 && shortArr[i - 1] > longArr[j])
				imin = i - 1;
			else
			{
				if(i == m)
					right_min = longArr[j];
				else if(j == n)
					right_min = shortAr[i];
				else
					right_min = Math.min(longArr[j], shortArr[i]);

				if(!isEven)
					return right_min;

				if(i == 0)
					left_max = longArr[j - 1];
				else if(j == 0)
					left_max = longArr[i - 1];
				else
					left_max = Math.max(longArr[j - 1], shortArr[i - 1]);

				return (right_min + left_max) / 2;
			}
		}
	}
}
