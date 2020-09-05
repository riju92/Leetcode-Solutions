/*
1130. Minimum Cost Tree From Leaf Values
Medium

1348

112

Add to List

Share
Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.

 

Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4
*/

class Solution
{
    public int mctFromLeafValues(int[] arr)
    {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int i : arr)
        {
            while(stack.peek() <= i)
            {
                int temp = stack.pop();
                result += temp * Math.min(i, stack.peek());
            }
            stack.push(i);
        }

        while(stack.size() > 2)
            result += stack.pop() * stack.peek();

        return result;
    }
}