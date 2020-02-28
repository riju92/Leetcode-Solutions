import java.util.*;

class Solution {
    public int bitonicSubSequence(int[] nums) 
    {
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];
        
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j] && lis[i]< lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        
        for(int i = nums.length - 2; i >= 0; i--)
        {
            for(int j = nums.length - 1; j > i; j--)
            {
                if(nums[i] > nums[j] && lds[i] < lds[j] + 1)
                {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        //System.out.println("LIS:" + lis[nums.length - 1]);
        //System.out.println("LDS:" + lds[nums.length -1]);
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(lis[i] + lds[i] - 1 > max)
            {
                max = lis[i] + lds[i] - 1;
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        Solution test = new Solution();
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("Longest bitonic subsequence is:" + test.bitonicSubSequence(arr));
    }
}