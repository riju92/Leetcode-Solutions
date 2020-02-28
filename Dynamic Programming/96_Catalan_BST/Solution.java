/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */
   
   class Solution {
    public int numTrees(int n) 
    {
        int[] trees = new int[n + 1];
        trees[0] = trees[1] = 1;
        
        for (int i = 2; i <= n; i++)
        {
            trees[i] = 0;
            for (int j = 0; j < i; j++)
            {
                trees[i] += trees[j] * trees[i - j -1];
            }
        }
        return trees[n];
    }
}
