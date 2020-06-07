/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution
{
	int max = 0;
	public int diamOfBTree(TreeNode root)
	{
		dfs(root);
		return max;	
	}
	public int dfs(TreeNode root)
	{
		if(root == null) return 0;

		int left = dfs(root.left);
		int right = dfs(root.right);
		max = Math.max();

		return Math.max(left, right) + 1;
	}

}
