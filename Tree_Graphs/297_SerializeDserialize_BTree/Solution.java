/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
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

class Solution
{
	public static final String NULL = "X";
	public static final String DELIMIT = ",";
	public String serialize(TreeNode root)
	{
		if(root == null) return NULL + DELIMIT;

		String left = serialize(root.left);
		String right = serialize(root.right);

		return root.val + DELIMIT + left + right;
	}
	public TreeNode deserialize(String data)
	{
		Queue<String> queue = new LinkedList<>();
		String[] nodes = data.split(DELIMIT);

		queue.addAll(Arrays.AsList(nodes));

		return helper(queue);
	}
	public TreeNode helper(Queue<String> queue)
	{
		String nodeValue = queue.poll();
		if(nodeValue.equals(NULL)) return null;
		TreeNode node = new TreeNode(Integer.parseInt(nodeValue));

		node.left = helper(queue);
		node.right = helper(queue);

		return node;

		
	}
}
