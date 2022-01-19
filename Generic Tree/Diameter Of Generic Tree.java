/*

Diameter Of Generic Tree

You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree.

*/
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  static int diameter = 0;
  public static int solution(Node node) // calculate diameter and return height
  {
      int dch = -1;
      int sdch = -1;
      for(Node child: node.children)
      {
          int ch = solution(child);
          if(ch > dch)
          {
              sdch = dch;
              dch = ch;
          }
          else if(ch > sdch)
          {
              sdch = ch;
          }
      }
      
      if(dch+sdch+2 > diameter)
        diameter = dch+sdch+2;
      return dch+1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    solution(root);
    System.out.println(diameter);
  }

}
