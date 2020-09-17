import java.util.*;

/*
2. Minimum Amount

Alex has a list of items to purchase at a market. The owner offers to discount each item after the first one by the lowest marked price among the prior items. No item's price can be discounted below 0 and the list of items may not be reordered. Calculate the totla payable amount

Example: 

prices: [2,5,1,4]


Alex pays for the first item since there are no previous items to compare to.
The second item costs 5 - 2 = 3.
The third item is free: max(1 - min(2,5), 0) = max(-1, 0) = 0
The fourth item costs 4 -1 = 3

The total cost to purchase all items is 2 + 3 + 0 + 3 = 8
The first item is not discounted and the minimum cost of any item is 0
*/

class Solution
{
    public int calculate(int[] prices)
    {
        int result = 0;
        int cost = 0;
        int discount = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(prices[0]);
        cost += prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            if(!minHeap.isEmpty())
                discount = minHeap.poll();
            
            result += (prices[i] - discount);

            if(result < 0)
                result = 0;

            minHeap.add(prices[i]);

            cost += result;
            //System.out.println("Cost[" + i + "]: " + cost);
        }

        return cost;
    }

    public static void main(String[] args) {
        
        Solution obj = new Solution();

        int[] arr = {2,5,1,4};

        int result = obj.calculate(arr);

        System.out.println("Price: " + result);
    }
}