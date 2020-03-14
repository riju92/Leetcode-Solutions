/*
977. Squares of a Sorted Array
Easy

798

72

Add to List

Share
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

class Solution {
    public int[] sortedSquares(int[] A) 
    {
        int j = 0;
        int n = A.length;
        
        while(j < n && A[j] < 0)
            j++;
        
        int i = j - 1;
            
        int[] ans = new int[n];
        int t = 0;
            
        while(i >= 0  && j < n)
        {
           if(A[i] * A[i] < A[j] * A[j])
           {
               ans[t++] = A[i] * A[i];
               i--;
            }
            else
            {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }
        while( i >= 0)
        {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while(j < n)
        {
            ans[t++] = A[j] * A[j];
            j++;
        }
        return ans;
        
    }
}