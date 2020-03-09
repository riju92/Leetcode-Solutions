/*
15. 3Sum
Medium

5724

697

Add to List

Share
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++)
        {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1]))
            {
                int l = i + 1;
                int h = nums.length - 1;
                int sum = 0 - nums[i];
                
                while(l < h)
                {
                    if(nums[l] + nums[h] == sum)
                    {
                        result.add(Arrays.asList(nums[i] , nums[l] , nums[h]));
                        while(l < h && nums[l] == nums[l + 1]) l++;
                        while(l < h && nums[h] == nums[h - 1]) h--;
                        l++;
                        h--;
                    }
                    else if(nums[l] + nums[h] < sum)
                    {
                        l++;
                    }
                    else
                    {
                        h--;
                    }
                }
            }
        }
        return result;
    }
}