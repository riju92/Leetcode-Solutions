public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     ListNode a = headA;
     ListNode b = headB;
     
     if (a == null || b == null)
     {
        return null;
     }
     while ( a != b )
     {
        if( a == null )
        {
            a = headB;
        }
        else
        {
            a = a.next;
        }
        
        if( b == null )
        {
            b = headA;
        }
        else
        {
            b = b.next;
        }
     }
     return a;
     
     }
    }
