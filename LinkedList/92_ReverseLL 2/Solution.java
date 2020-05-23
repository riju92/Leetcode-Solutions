/*
92. Reverse Linked List II
Medium

2095

135

Add to List

Share
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        //int count = 0;
        for(int i = 0; i<m-1; i++) curr = curr.next;
        
        //System.out.println("Curr:"+curr.val);
        ListNode start = curr.next;
        ListNode end = start.next;
        int count = 0;
        while(count != n - m)
        {
            start.next = end.next;
            end.next = curr.next;
            curr.next = end;
            end = start.next;
            count++;
        }
        
        return dummy.next;
    }
}