/*
203. Remove Linked List Elements
Easy

1418

84

Add to List

Share
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) 
    {
        ListNode helpMe = new ListNode(0);
        ListNode curr = head;
        helpMe.next = head;
        ListNode prev = helpMe;
        while(curr != null )
        {
            if(curr.val == val)
            {
                prev.next = curr.next;
            }
            else
            {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return helpMe.next;
    }
    
}