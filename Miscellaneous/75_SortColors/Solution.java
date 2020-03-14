/*
75. Sort Colors
Medium

2564

192

Add to List

Share
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/

class Solution {
    public void sortColors(int[] nums) 
    {
        int temp;
        int curr = 0;
        int i = 0;
        int j = nums.length - 1;
        
        while(curr <= j)
        {
            if(nums[curr] == 0)
            {
                temp = nums[i];
                nums[i++] = nums[curr];
                nums[curr++] = temp;
            }
            else if(nums[curr] == 2)
            {
                temp = nums[curr];
                nums[curr] = nums[j];
                nums[j--] = temp;
            }
            else
                curr++;
        }
    }
}