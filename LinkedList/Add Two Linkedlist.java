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
    
    public static ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null)
        {
            ListNode forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        {
            if(l1 == null)
                return l2;
            else
                return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0)
        {
            int sum = carry;
            if(l1 != null)
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;
                
            int digit = sum%10;
            carry = sum/10;
            dummy.next = new ListNode(digit);
            dummy = dummy.next;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
                
        }
        return reverse(head.next);
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}
