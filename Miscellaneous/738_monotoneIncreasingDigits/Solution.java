/*
738. Monotone Increasing Digits
Medium

464

62

Add to List

Share
Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
*/

class Solution
{
    public int monotoneIncreasingDigits(int n)
    {
        char[] digits = Integer.toString(n).toCharArray();

        int marker = digits.length;
        for(int i = digits.length - 1; i > 0; i--)
        {
            if(digits[i] - '0' < digits[i - 1] - '0')
            {
                digits[i - 1] -= 1;
                marker = i;
            }
        }

        for(int i = marker; i < digits.length; i++)
            digits[i] = '9';

        return Integer.valueOf(new String(digits));
    }
}