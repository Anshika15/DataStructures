/*
Largest Bst Subtree

1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.

*/

import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

 
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    
    BSTPair res = solution(root);
    System.out.println(res.BSTNode.data + "@" + res.BSTSize);
  }
  
  static BSTPair solution(Node root)
  {
      if(root == null)
      {
          BSTPair bp = new BSTPair();
          bp.min = Integer.MAX_VALUE;
          bp.max = Integer.MIN_VALUE;
          bp.isBST = true;
          return bp;
      }
      
      BSTPair bpl = solution(root.left);
      BSTPair bpr = solution(root.right);
      
      BSTPair bp = new BSTPair();
      bp.min = Math.min(root.data, Math.min(bpl.min, bpr.min));
      bp.max = Math.max(root.data, Math.max(bpl.max, bpr.max));
      
      bp.isBST = bpl.isBST && bpr.isBST && (bpl.max <= root.data && bpr.min >= root.data);
      
      if(bp.isBST)
      {
          bp.BSTNode = root;
          bp.BSTSize = bpl.BSTSize + bpr.BSTSize + 1;
      }
      else if(bpl.BSTSize > bpr.BSTSize)
      {
          bp.BSTNode = bpl.BSTNode;
          bp.BSTSize = bpl.BSTSize;
      }
      else
      {
          bp.BSTNode = bpr.BSTNode;
          bp.BSTSize = bpr.BSTSize;
      }
      
      return bp;
      
  }
  
  static class BSTPair{
      int min;
      int max;
      boolean isBST;
      Node BSTNode; // largest BST Node
      int BSTSize; // largest BST Size
  }

}
