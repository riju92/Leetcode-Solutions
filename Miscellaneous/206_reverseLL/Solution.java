/*
206. Reverse Linked List
Easy

3683

82

Add to List

Share
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
class Solution {
    public ListNode reverseList(ListNode head) 
    {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
*/

class Solution
{
    public ListNode reverseList(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return n;
    }
}

