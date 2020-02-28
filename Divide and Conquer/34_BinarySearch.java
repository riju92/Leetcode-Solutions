/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int[] res = {-1,-1};
        int lo = 0;
        int high = nums.length - 1;
        
        while (nums[lo] < nums[high])
        {
            int mid = lo + (high - lo)/2;
            if ( nums[mid] > target)
            {
                high = mid - 1;
            }
            else if (nums[mid] < target)
            {
                lo = mid + 1;
            }
            else 
            {
                if ( nums[lo] == nums[mid])
                {
                high--;
                }
                else
                {
                    lo++;
                }    
            }
        }
     
       if (nums[lo] == nums[high] && nums[lo] == target)
    {
        res[0] = lo;
        res[1] = high;
    }
    return res; 
        
    }
    
}
