/*
83. Remove Duplicates from Sorted List
Easy

1372

104

Add to List

Share
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/


 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

class Solution {
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null) return head;
        ListNode temp = head;

        while(temp.next != null)
        {
            if(temp.val == temp.next.val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head;
    }
}
