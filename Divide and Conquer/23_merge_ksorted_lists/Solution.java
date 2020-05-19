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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        for(ListNode head : lists)
        {
            if(head != null) minHeap.add(head);
            
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minHeap.isEmpty())
        {
            head.next = minHeap.poll();
            head = head.next;
            
            if(head.next != null) minHeap.add(head.next);
        }
        return dummy.next;
    }
}