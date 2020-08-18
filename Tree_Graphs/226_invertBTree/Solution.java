/*
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
	//RECURSIVE
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null) return null;

		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}

	//BFS USING QUEUE
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null) return null;

		Queue<TreeNode> queue = new Queue<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}
		return root;

	}
}
