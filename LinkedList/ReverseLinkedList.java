import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
      if(head == null || head.next == null)
        return head;
      
      ListNode curr = head;
      ListNode prev = null;
      ListNode forw = null;
      
      while(curr != null)
      {
          forw = curr.next;
          curr.next = prev;
          
          prev = curr;
          curr = forw;
       
      }
      
         
        return prev;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
