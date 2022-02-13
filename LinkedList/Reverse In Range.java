/* 

Reverse In Range

1. Given a singly linklist, Reverse a linkedlist from position starting position to end position.
2. Do it in one-pass. without using any extra space.
3. Indexing start from numeric 1.

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

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        if(head == null || head.next == null)
            return head;

        while(n < m)
        {
            ListNode temp1 = getAt(n, head);
            ListNode temp2 = getAt(m, head);

            int temp = temp1.val;
            temp1.val = temp2.val;
            temp2.val = temp;
            n++;
            m--;
        }
        return head;
    }

    public static ListNode getAt(int idx, ListNode head)
    {
        if(head == null)
            return null;
        
        ListNode curr = head;
        int i = 1;
        while(curr != null && i != idx)
        {
            i++;
            curr = curr.next;
        }
        return curr;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}
