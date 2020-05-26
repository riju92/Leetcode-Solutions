/*
708. Insert into a Sorted Circular Linked List
Medium

275

287

Add to List

Share
Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.

 

Example 1:


 
Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.



Example 2:

Input: head = [], insertVal = 1
Output: [1]
Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.
Example 3:

Input: head = [1], insertVal = 0
Output: [1,0]
*/



/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) 
    {
        
        int x = insertVal;
        if(head == null)     // If head is null just insert the val in new node and point the node to itself
        {
            Node node = new Node(x, null);
            node.next = node;
            return node;
        }
        
        // is start is NOT null, try to insert it into correct position
        Node curr = head;
        while(true)
        {
            if(curr.val < curr.next.val)          // case 1A: has a tipping point, still climbing 
            {
                if(curr.val <= x && x <= curr.next.val)
                {
                    insert(x, curr);
                    break;
                }
            }
            else if(curr.val > curr.next.val)      // case 1B: has a tipping point, about to return back to min node
            {
                if(curr.val <= x || x <= curr.next.val)
                {
                    insert(x, curr);
                    break;
                }
            }
            else     // case 2: NO tipping point, all flat
            {
                if(curr.next == head)   // insert x before we traverse all nodes back to start
                {
                    insert(x, curr);
                    break;
                }
            }
            curr = curr.next;       // None of the above three cases met, go to next node
        }
        return head;
    }
    
    public void insert(int val, Node node)
    {
        node.next = new Node(val, node.next);    // insert value x after Node cur
    }
}