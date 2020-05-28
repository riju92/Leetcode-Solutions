/*
86. Partition List
Medium

1150

285

Add to List

Share
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) 
    {
        ListNode curr = head;
        ListNode t1 = new ListNode(0);
        ListNode t2 = new ListNode(0);
        ListNode choto = t1;
        ListNode boro = t2;

        while(curr != null)
        {
            if(curr.val < x)
            {
                l1.next = curr;
                l1 = l1.next;
            }
            if(curr.val >= x)
            {
                l2.next = curr;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        l1.next = boro.next;
        l2.next = null;
        return choto.next;
    }
}