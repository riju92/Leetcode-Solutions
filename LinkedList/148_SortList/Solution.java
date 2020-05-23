/*
148. Sort List
Medium

2450

120

Add to List

Share
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        //fast = head;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
        
    }
    
    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                result.next = l1;
                l1 = l1.next;
            }
            else
            {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if(l1 != null) result.next = l1;
        if(l2 != null) result.next = l2;
            
        return head.next;
    }
}