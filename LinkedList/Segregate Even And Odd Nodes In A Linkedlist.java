import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null)
        return head;
        
        ListNode evenNode = new ListNode(-1);
        ListNode oddNode = new ListNode(-1);
        ListNode etail = evenNode;
        ListNode otail = oddNode;
        ListNode curr = head;
        
        while(curr != null)
        {
            if(curr.val % 2 != 0)
            {
                otail.next = curr;
                otail = otail.next;
            }
            else 
            {
                etail.next = curr;
                etail = etail.next;
            }
            curr = curr.next;
        }
        
        etail.next = null;
        otail.next = null;
        etail.next = oddNode.next;
        return evenNode.next;
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
