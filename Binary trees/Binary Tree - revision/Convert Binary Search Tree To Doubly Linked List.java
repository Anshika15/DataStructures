/*

Convert Binary Search Tree To Doubly Linked List

1. Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
2. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
3. The order of nodes in DLL must be the same as in Inorder for the given Binary Search Tree. The first node of Inorder traversal (leftmost node in BST) must be the head node of the DLL. 

*/

import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }
  
  /*
  
 //  O(n) space and time 
 
  public static void addAllLeft(Node node, LinkedList<Node> stack)
  {
      while(node != null)
      {
        stack.addFirst(node);  
        node = node.left;
      }
  }

  public static Node bToDLL(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    addAllLeft(root, stack);
    
    Node dummy = new Node(-1);
    Node prev = dummy;
    
    while(stack.size() > 0)
    {
        Node curr = stack.removeFirst();
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        
        addAllLeft(curr.right, stack);
    }
    
    Node head = dummy.right;
    dummy.right = head.left = null;
    
    head.left = prev;
    prev.right = head;
    
    return head;
  }
  
  */
  
  
  /* using morrise traversal O(1) space O(n) time */
  
  public static Node getRightMostNode(Node node, Node curr)
  {
      while(node.right != null && node.right != curr)
        node = node.right;
      return node;
  }
  
  public static Node bToDLL(Node root) {
     
     Node dummy = new Node(-1);
     Node prev = dummy;
     Node curr = root;
     while(curr != null)
     {
         Node leftNode = curr.left;
         if(leftNode == null)
         {
             /* inorder */
             
             /* links created */
             prev.right = curr;
             curr.left = prev;
             prev = curr;
             
             /* move */
             curr = curr.right;
         }
         else
         {
             Node grm = getRightMostNode(leftNode, curr);
             if(grm.right == null)/* create a thread */
             {
                 grm.right = curr;
                 curr = curr.left;
             }
             else
             {
                 /* remove the thread*/
                 /* inorder */
                 
                 grm.right = null;
                 
                 /* links created */
                prev.right = curr;
                curr.left = prev;
                prev = curr;
             
                /* move */
                curr = curr.right;
             }
         }
     }
     
     Node head = dummy.right;
     dummy.right = head.left = null;
     head.left = prev;
     prev.right = head;
     return head;
  }
  

  // input_section=================================================

  public static void display(Node node) {
    Node head = node;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.right;
      if (node == head)
        break;
    }

  }

  public static Node constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    Node node = new Node(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static Node constructFromInOrder(int[] inOrder) {
    int n = inOrder.length;
    return constructFromInOrder_(inOrder, 0, n - 1);
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    Node root = constructFromInOrder(in);
    root = bToDLL(root);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}
