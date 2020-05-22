/*
445. Add Two Numbers II
Medium

1284

147

Add to List

Share
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        
        while(l1 != null)
        {
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            s2.push(l2);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0)
        {
            int t1 = (!s1.isEmpty())? s1.pop().val : 0;
            int t2 = (!s2.isEmpty())? s2.pop().val : 0;
            
            int sum = t1 + t2 + carry;
            carry = sum / 10;
            ListNode result = new ListNode(sum%10);
            result.next = head;
            head = result;
            
        }
         return head;
    }
}