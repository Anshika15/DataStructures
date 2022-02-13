/* 
Merge K Sorted Linkedlist

You are given an array of k linked-lists, each linked-list is sorted in increasing order.
Merge all the linkedlists into one sorted linkedlist and return it.


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

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length-1);
    }

    public static ListNode mergeLists(ListNode lists[], int start, int end)
    {
        if(start > end)
            return null;
        if(start == end)
            return lists[start];
        int mid = start + (end - start) /2;
        
        ListNode node1 = mergeLists(lists, start, mid);
        ListNode node2 = mergeLists(lists, mid+1, end);
        
        return mergeTwoLL(node1, node2);
    }
    
    public static ListNode mergeTwoLL(ListNode node1, ListNode node2)
    {
        if(node1 == null || node2 == null)
            return node1 != null ? node1 : node2;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode one = node1;
        ListNode two = node2;
        
        while(one != null && two != null)
        {
            if(one.val < two.val)
            {
                prev.next = one;
                one = one.next;
            }
            else
            {
                prev.next = two;
                two = two.next;
            }
            prev = prev.next;
        }
        
        prev.next = one != null ? one : two;
        return dummy.next;
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}
