import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode prev = null;
        ListNode forw = null;
        ListNode curr = head;
        
        while(curr != null)
        {
            forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
    
    public static ListNode midElement(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public static boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null)
        return true;
        
        ListNode mid = midElement(head);
        ListNode newHead = mid.next;
        mid.next = null;
        
        newHead = reverse(newHead);
        
        ListNode c1 = head;
        ListNode c2 = newHead;
        while(c1 != null && c2 != null)
        {
            if(c1.val != c2.val)
                return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        
        newHead = reverse(newHead);
        mid.next = newHead;
        return true;
        
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

        System.out.println(isPalindrome(dummy.next));
    }
}