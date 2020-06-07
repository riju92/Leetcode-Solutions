/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]*/

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
*/
 *//BFS
 * class Solution
 * {
 * 	public List<List<Integer>> levelOrderBottom(TreeNode root)
 * 	{
 * 		Queue<TreeNode> queue = new Queue<TreeNode>();
 * 		List<List<Integer>> result = new LinkedList<List<Integer>>();
 *
 *		if(root == null) return result;
 *
		queue.offer(root);
 		while(!queue.isEmpty())
		{
			List<Integer> temp = new List<Integer>;
			int level = queue,size();
			for(int i = 0; i < level; i++)
			{
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				temp.add(queue.poll().val);	
			}
			result.add(0, temp);
		
		}
		return result;
 *
 * 	}
 * }
 *
 *//DFS

 class Solution
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		dfs(result, root, 0);
		return result;
	}

	public void dfs(List<List<Integer>> result, TreeNode root, int level)
	{
		if(root == null) return;
		if(level >= result.size())
		{
			result.add(0, new LinkedList<Integer>() );
		}

		dfs(result, root.left, level + 1);
		dfs(result, root.right, level + 1);
		result.get(List.size() - level - 1)add(root.val);

	}
}
