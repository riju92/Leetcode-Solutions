/*
 * 42. Trapping Rain Water
Hard

7015

122

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution
{
	public int trap(int[] height)
	{
		if(height.length <= 2) return 0;
		int max = 0;
		for(int i = 0; i < height.length; i++)
		{
			if(height[max] < height[i]) max = i;
		}
		int water = 0;
		int high = 0;
		for(int i = 0; i < max; i++)
		{
			if(high < height[i]) high = height[i];
			else
				water += high - height[i];
		}
		high = 0;
		for(int i = height.length - 1; i > max; i-- )
		{
			if(high < height[i]) high = height[i];
			else
				water += high - height[i];
		}
		return water;
	}
}
