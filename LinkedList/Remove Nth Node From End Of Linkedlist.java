/*

Remove Nth Node From End Of Linkedlist

Given a singly linklist, remove the nth node from the end of the list and return its head.

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

  public static ListNode removeNthFromEnd(ListNode head, int n) {

    if(head == null)
      return head;

    ListNode slow = head;
    ListNode fast = head;

    for(int i = 0; i < n; i++)
    {
      fast = fast.next;

    }
    if(fast == null)
      return head.next;

    while(fast.next != null)
    {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return head;
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

    int m = scn.nextInt();
    h1 = removeNthFromEnd(h1, m);
    printList(h1);
  }
}
