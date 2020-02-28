/**Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0. */

class Solution {
    public int maxProfit(int[] prices) 
    {
        
        int f_sum = 0;
        int curr_sum = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++)
        {
            if(prices[i] < curr_sum)
            {
                curr_sum = prices[i];
                System.out.println("curr_sum:" + curr_sum);
            }
            else
            {
                f_sum = Math.max(f_sum, prices[i] - curr_sum);
                System.out.println("f_sum:" + f_sum);
            }
        }
        return f_sum;    
    }
}

class Solution {
    public int maxProfit(int[] prices) 
    {
        
        int f_sum = 0;
        int curr_sum = 0;
        for (int i=1; i<prices.length; i++)
        {
            curr_sum += prices[i] - prices[i-1];
            if(curr_sum < 0)
                curr_sum = 0;
            
            if (curr_sum > f_sum)
            {
                f_sum = curr_sum;
            }
        }
        return f_sum;    
    }
}
