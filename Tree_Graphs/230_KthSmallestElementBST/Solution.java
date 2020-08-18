/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.



Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
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
	public int kthSmallest(TreeNode root, int k)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while(root != null || !stack.isEmpty())
		{
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(--k == 0) break;
			root = root.right;
		}
		return root.val;
	}
}
