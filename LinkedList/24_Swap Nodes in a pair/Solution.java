/*
24. Swap Nodes in Pairs
Medium

2064

162

Add to List

Share
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next != null)
        {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            pre.next = temp;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}