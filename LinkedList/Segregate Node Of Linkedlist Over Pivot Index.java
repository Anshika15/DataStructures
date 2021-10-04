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

  public static ListNode segregate(ListNode head, int pivotIdx) {
     if(head == null || head.next == null)
        return head;
        
    ListNode pivot = head;
    int idx = 0;
    int data = 0;
    while(pivot != null)
    {
        if(idx == pivotIdx)
        {
            data = pivot.val;
            break;
        }
        idx++;
        pivot = pivot.next;
    }
    
    ListNode small = new ListNode(-1);
    ListNode smallPrev = small;
    ListNode larger = new ListNode(-1);
    ListNode largerPrev = larger;
    
    ListNode curr = head;
    idx = 0;
    while(curr != null)
    {
        if(idx == pivotIdx)
        {
            pivot = curr;
        }
        else if(curr.val <= data)
        {
            smallPrev.next = curr;
            smallPrev = smallPrev.next;
        }
        else
        {
            largerPrev.next = curr;
            largerPrev = largerPrev.next;
        }
        curr = curr.next;
        idx++;
    }
    
    smallPrev.next = pivot;
    pivot.next = larger.next;
    largerPrev.next = null;
    
    return small.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}
