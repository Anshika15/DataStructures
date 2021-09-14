import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        
        if(head == null)
            return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        HashMap<ListNode, ListNode> map = new HashMap<>();
        
        ListNode curr = head;
        while(curr != null)
        {
           prev.next = new ListNode(curr.val);
           map.put(curr, prev.next);
           curr = curr.next;
           prev = prev.next;
        }
        
        ListNode nhead = dummy.next;
        ListNode curr2 = nhead;
        ListNode curr1 = head;
        while(curr1 != null)
        {
           curr2.random = map.get(curr1.random);
           curr1 = curr1.next;
           curr2 = curr2.next;
        }
        
        return nhead;
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
