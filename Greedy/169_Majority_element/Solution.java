/*
169. Majority Element
Easy

2455

204

Add to List

Share
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    public int majorityElement(int[] nums) 
    {
        int maj_element = 0;
        int c = check_candidate(nums);
        
        if(Is_majority(nums,c))
        {
            maj_element = c;
        }
        //System.out.println(maj_element);
        return maj_element;
        
    }
    
    public boolean Is_majority(int[] nums, int c)
    {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == c) 
            {
                count++;
            }
            
            if(count > nums.length / 2 ) return true;
        }
        return false;
    }
    
    public int check_candidate(int[] nums)
    {
        int count = 1; 
        int index = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[index] == nums[i]) 
                count++;
            else    
                count--;
            
            if(count == 0) 
            {
                index = i;
                count = 1;
                System.out.println("Line 46 " +index);
            }   
        }
   
    return nums[index];
    }
}