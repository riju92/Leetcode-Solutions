/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
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
	public List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> result = new LinkedList<List<Integer>>;
		List<Integer> current = new LinkedList<Integer>;

		temp(root, sum, result, current);
		return result;
	}
	public void temp(TreeNode root, int sum, List<List<Integer>> result, List<Integer> current)
	{
		if(root == null) return;
		current.add(root.val);
		if(sum - root.val == 0 && root.left == null && root.right == null)
		{
			result.add(new LinkedList(current));
			current.remove(current.size() - 1);
			return;
		}
		else
		{
			temp(root.left, sum - root.val, result, current);
			temp(root.right, sum - root.val, result, current);
		}
		current.remove(current.size() - 1);
	} 
}
