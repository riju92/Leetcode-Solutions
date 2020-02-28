public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        Set<ListNode> h1 = new HashSet<>();
        while (headA != null)
        {
            h1.add(headA);
            headA = headA.next;
        }
        
        while (headB != null)
        {
            if(h1.contains(headB))
            {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
