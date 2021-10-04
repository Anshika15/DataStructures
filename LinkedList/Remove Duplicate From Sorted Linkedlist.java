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

    public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        //dummy.next = curr;
        ListNode n = dummy;
        
        while(curr != null)
        {
            while(curr != null && curr.val == dummy.val)
                curr = curr.next;
            
            dummy.next = curr;
            dummy = dummy.next;
            
            if(curr != null) curr = curr.next;
        }
        return n.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

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
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}
