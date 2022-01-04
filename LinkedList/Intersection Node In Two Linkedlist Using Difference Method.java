/*

Intersection Node In Two Linkedlist Using Difference Method

1. Given the heads of two singly linked-lists headA and headB
2. Return the node at which the two lists intersect. 
3. If the two linked lists have no intersection, return null.

*/
import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static int size(ListNode node)
    {
        ListNode n = node;
        int count = 0;
        while(n != null)
        {
            count++;
            n =n.next;
        }
        return count;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        
        ListNode t1 = headA;
        ListNode t2 = headB;
        
        int delta = Math.abs(size(headA) - size(headB));
        if(size(headA) > size(headB))
        {
            for(int i = 0; i < delta; i++)
                t1 = t1.next;
        }
        else
        {
            for(int i = 0; i < delta; i++)
                t2 = t2.next;
        }
        
        while(t1 != t2)
        {
            t1 = t1.next;
            t2 = t2.next;
        }
        
        if(t1 == t2)
            return t1;
        return null;
    }

    // Input_code===================================================

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
