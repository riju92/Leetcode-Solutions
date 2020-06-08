/*
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

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
//RECURSIVE
class Solution
{
	public int pathSum(TreeNode root, int sum)
	{
		if(root == null) return 0;
		return temp(root. sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	public int temp(TreeNode curr, int sum)
	{
		if(curr == null) return 0;

		return (curr.val == sum? 1 : 0) + temp(curr.left, sum - curr.val) + temp(curr.right, sum - curr.val);
	}
}

//ITERATIVE
class Solution
{
    public int pathSum(TreeNode root, int sum)
    {
        if(root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return temp(root, 0, sum, map);
    }
    public int temp(TreeNode curr, int sum, int target, HashMap<Integer, Integer> map)
    {
        if(curr == null) return 0;
        
        sum += curr.val; // update the prefix sum by adding the current val
        
        int pathToCurr = map.getOrDefault(sum - target, 0); // get the number of valid path, ended by the current node
        
        map.put(sum, map.getOrDefault(sum, 0) + 1); // update the map with the current sum, so the map is good to be passed to the next recursion
        
        int result = pathToCurr + temp(curr.left, sum, target, map) + temp(curr.right, sum, target, map); // add the 3 parts discussed in 8. together
        
        map.put(sum, map.get(sum) - 1); // restore the map, as the recursion goes from the bottom to the top
        return result;
    }
}
