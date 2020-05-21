/*
143. Reorder List
Medium

1658

109

Add to List

Share
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) 
    {
        if(head == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        ListNode head2 = reverse(p1.next);
        p1.next = null;
        
        while(head != null && head2 != null)
        {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            
            head2.next = head.next;
            head.next = head2;
            
            head = tmp1;
            head2 = tmp2;
        }
        
    }
    
    public ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode cur = node;
        
        while(cur != null)
        {
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }
        return prev;
    }
}