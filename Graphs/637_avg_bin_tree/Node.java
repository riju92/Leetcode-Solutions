/*
637. Average of Levels in Binary Tree
Easy

1051

145

Add to List

Share
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
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

// BFS Approach
class Solution {
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int count = queue.size();
            double sum = 0;
            
            for (int i = 0; i < count; i++)
            {
                TreeNode curr = queue.poll();
                sum += curr.val;
                
                if(curr.right != null) queue.offer(curr.right);
                if(curr.left != null) queue.offer(curr.left);
            }
            result.add(sum / count);
            
        }
        return result;
    }
}


//DFS approach

class Node
{
    double sum;
    int count;
    Node(double d, int c)
    {
        d = sum;
        c = count;
    }

    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Node> temp = new ArrayList<>();
        helper(root, temp, 0);
        List<Double> res = new LinkedList<>();
        
        for(int i = 0; i < temp.size(); i++)
        {
            res.add(temp.get(i).sum / temp.get(i).count);
        }
        return res;
    }
    
    public void helper(TreeNode root, List<Node> temp, int level)
    {
        if(root == null) return ;
        
        if(level == temp.size())
        {
            Node node = new Node(root.val , 1);
            temp.add(node);
         }
        else
        {
            temp.get(level).sum += sum;
            temp.get(level).count++;
        }
        
        helper(root.left , temp , level + 1);
        helper(root.right , temp , level + 1);
    }
}