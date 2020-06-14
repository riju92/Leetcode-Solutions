/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
		if(queue.isEmpty()) return null;

		Queue<Integer> queue = new LinkedList<>();
	        String[] s = data.split(DELIMIT);

		for(String node : s)
		{
			if(node.equals(NULL)) continue;
			queue.offer(Integer.parseInt(node));

		}	
		return helper(queue);
	}
	public TreeNode helper(Queue<Integer> queue)
	{
		if(queue.isEmpty()) return null;
		Queue<Integer> left = new LinkedList<>();

		int nodeValue = queue.poll();
		TreeNode node = new TreeNode(nodeValue);

		while(!queue.isEmpty() && nodeValue > queue.peek())
		{
			left.offer(queue.poll());
		}
		
		node.left = helper(left);
		node.right = helper(queue);

		return node;
	}
}
