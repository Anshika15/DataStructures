/*
Segregate Node Of Linkedlist Over Last Index.

1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
2. pivot is always be last index of linkedlist.
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.

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
    
    public static ListNode getTail(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        
        while(curr.next != null)
        {
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        ListNode tail = getTail(head);
        
        ListNode curr = head;
        ListNode sm = new ListNode(-1);
        ListNode smp = sm; // smaller perv
        
        ListNode l = new ListNode(-1);
        ListNode lp = l; // larger prev
        
        while(curr != null)
        {
            if(curr.val <= tail.val)
            {
                smp.next = curr;
                smp = smp.next;
            }
            else
            {
                lp.next = curr;
                lp = lp.next;
            }
            curr = curr.next;
        }
        smp.next = l.next;
        lp.next = null;
        return smp;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}
