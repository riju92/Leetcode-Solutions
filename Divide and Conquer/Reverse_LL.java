/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
        {
            return head;
        }
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        while ( curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        head = prev;
        return head;
        
    }
}
