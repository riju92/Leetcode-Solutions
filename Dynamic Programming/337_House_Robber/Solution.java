/*
337. House Robber III
Medium

2097

46

Add to List

Share
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) 
    {
            int[] res = robsub(root);
            return Math.max(res[0] , res[1]);
    }
    
    private int[] robsub(TreeNode root)
    {
        if(root == null) return new int[2];
        
        int[] l = robsub(root.left);
        int[] r = robsub(root.right);
        int[] res = new int[2];
        
        res[0] = Math.max(l[0] , l[1]) + Math.max(r[0] , r[1]); 
        res[1] = root.val + l[0] + r[0];
        
        return res;
    }
}