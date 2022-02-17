/* 

Subtract Two Linked Lists

*/

import java.util.*;
  
  public class Main {

      public static Node reverse(Node node)
      {
          if(node == null || node.next == null)
            return node;

          Node curr = node;
          Node prev = null;
          Node forw = null;

          while(curr != null)
          {
            forw = curr.next;

            curr.next = prev;
            prev = curr;

            curr = forw;
          }
          return prev;

      }
  

      // This function takes as input the head of two linked lists. 
      // This function should return the head of the resultant linked list.
      public static Node sublinkedList(Node l1, Node l2) {
         if(l2 == null)
            return l1;
         if(l1 == null)
         {
             l2.data = -l2.data;
             return l2;
         }

         l1 = reverse(l1);
         l2 = reverse(l2);

         Node nhead = new Node(-1);

         Node itr = nhead;

         Node c1 = l1;
         Node c2 = l2;
         int borrow = 0;

         while(c1 != null) // its given in question that len of l1 is greater than l2
         {
             int diff = borrow + c1.data - (c2 != null ? c2.data : 0);

             if(diff < 0)
             {
                 borrow = -1;
                 diff += 10;
             }
             else
             {
                 borrow = 0;
             }

             itr.next = new Node(diff);
             itr = itr.next;

             c1 = c1.next;
             if(c2 != null)
                c2 = c2.next;

         }
         return reverse(nhead.next);
      }
  
  
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int a1 = sc.nextInt();
          head = insert(head, a1);
  
          for (int i = 1; i < n; i++) {
              int a = sc.nextInt();
              head = insert(head, a);
          }
  
          int n2 = sc.nextInt();
          int a2 = sc.nextInt();
          head2 = insert(head2, a2);
  
          for (int i = 1; i < n2; i++) {
              int a = sc.nextInt();
              head2 = insert(head2, a);
          }
  
          head3 = sublinkedList(head, head2);
          display(head3);
  
      }
  
      // Class declaration for a Node of the Linked List
      static class Node {
          int data;
          Node next;
  
          public Node(int data) {
              this.data = data;
              this.next = null;
          }
  
      }
  
      static Node head;
  
      static Node head2;
  
      static Node head3;
  
      
      public static Node insert(Node head, int data) {
  
          if (head == null) {
              return new Node(data);
          }
  
          head.next = insert(head.next, data);
          return head;
      }
  
      
      public static void display(Node head) {
          for (Node node = head; node != null; node = node.next) {
              System.out.print(node.data + " ");
          }
      }
  
  }
