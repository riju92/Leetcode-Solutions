/*
 * 101. Symmetric Tree
Easy

3867

89

Add to List

Share
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
	public boolean isSymmetric(TreeNode root)
	{
		return root == null || temp(root.left, root.right);
	}
	public boolean temp(TreeNode left, TreeNode right)
	{
		if(left == null || right == null) return left == right;
		if(left.val != right.val) return false;
		return temp(left.left, right.right) && temp(left.right, right.left);
	}
}
