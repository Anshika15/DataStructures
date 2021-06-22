import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
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
    
    
    public static void unfold(ListNode head) {
        
        if(head == null || head.next == null)
            return;
        
        ListNode fhead = head;
        ListNode shead = head.next;
        
      //  ListNode forw = null;
        
        ListNode fprev = fhead;
        ListNode sprev = shead;
        
        /* even length and odd length case */
        while(sprev != null && sprev.next != null)
        {
            ListNode forw = sprev.next; // backup
            
            fprev.next = forw;
            sprev.next = forw.next;
            
            fprev = fprev.next;
            sprev = sprev.next;
            
            
        }
        
        fprev.next = null;
        
        shead = reverse(shead);
        fprev.next = shead;
        
        

    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}