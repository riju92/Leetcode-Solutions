/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		boolean order = true;
		int size = 1
		queue.add(root);

		if(root == null) return result;

		while(!queue.isEmpty())
		{
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < level; i++)
			{
				TreeNode node = queue.poll();
				if(order) temp.add(node.val);
				else temp.add(0, node.val);

				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			size = queue.size();
			order = order ? false : true;
			result.add(temp);
		}
		return result;

	}
}
