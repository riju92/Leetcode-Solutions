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
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        for(ListNode list : lists)
        {
            if(list != null) minHeap.add(list);
            
        }
          
        while(!minHeap.isEmpty())
        {
            curr.next = minHeap.poll();
            curr = curr.next;
            
            if(curr.next != null) minHeap.add(curr.next);
        }
        return head.next;
    }
}