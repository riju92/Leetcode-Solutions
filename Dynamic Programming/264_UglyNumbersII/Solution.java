/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
*/

class Solution {
    public int nthUglyNumber(int n) 
    {
        int next_ugly_no = 1;
        int[] ugly = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int nxt_mult_2 = 2;
        int nxt_mult_3 = 3;
        int nxt_mult_5 = 5;
        ugly[0] = 1;
        for (int i = 1; i < n; i++)
        {
            next_ugly_no = Math.min(nxt_mult_2, Math.min(nxt_mult_3 , nxt_mult_5) );
            ugly[i] = next_ugly_no;
            if (next_ugly_no == nxt_mult_2)
            {
                i2 +=1;
                nxt_mult_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == nxt_mult_3)
            {
                i3 +=1;
                nxt_mult_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == nxt_mult_5)
            {
                i5 +=1;
                nxt_mult_5 = ugly[i5] * 5;
            }
        }
        return next_ugly_no;
    }
}
