/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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

class Solution
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode curr = head;
		int count = 0;
		while(curr != null && count != k) // to find the k+1 node
		{
			curr = curr.next;
			count++;
		}

		if(count == k) //// if k+1 node is found
		{
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
        // head - head-pointer to direct part, 
        // curr - head-pointer to reversed part;

			while(count > 0) //reverse current k group
			{
				ListNode temp = head.next; // tmp-next head in direct path
				head.next = curr; // preappending 'direct' head to the reversed list
				curr = head; // move head of reversed part to a new node
				head = temp; // move 'direct' head to the next node in direct part
				count--;
			}
			head = curr;
		}
		return head;
	}	
}
