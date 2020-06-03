/*
 Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Follow up:

Recursive solution is trivial, could you do it iteratively?

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
*/

//RECURSIVE

class Solution
{
	List<Integer> list = new ArrayList<>();
	public List<Integer> preorder(Node root)
	{
		if(root == null) return list;
		list.add(root.val);
		for(Node node : root.children)
		{
			preorder(node);
		}
		
		return list;
	}

}

//ITERATIVE

class Solution
{
	public List<Integer> preorder(Node root)
	{
		List<Integer> list = new List<>();
		if(root == null) return list;

		Stack<Node> stack = new Stack<>();
		stack.add(root);

		while(!stack.isEmpty())
		{
			root = stack.pop();
			list.add(root.val);
			for(int i = root.children.size() -1; i >= 0; i--)
			{
				stack.add(root.children.get(i));
			}
		}
		return list;
	}

}

