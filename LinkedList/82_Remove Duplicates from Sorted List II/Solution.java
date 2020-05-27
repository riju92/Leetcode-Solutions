import javax.lang.model.util.ElementScanner6;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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

public class Solution {
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null) return head;
        ListNode temp  = new ListNode(0);
        temp.next = head;
        ListNode curr = head;
        ListNode prev = temp;

        while(curr != null)
        {
            while(curr.next != null && curr.val == curr.next.val)
            {
                curr = curr.next;
            }
            if(prev.next == curr)
                prev = prev.next;
            else
                prev.next = curr.next;

            curr = curr.next;
        }

        return temp.next;
    }
    
}