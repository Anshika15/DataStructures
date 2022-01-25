/*
Serialize And Deserialize N - Ary Tree

1. Serialization is to store tree in a file so that it can be later restored.
2. The structure of tree must be maintained. Deserialization is reading tree back from file.

*/

import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  static class Node {
    public int val;
    public ArrayList<Node> children;

    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  // Encodes a tree to a single string.
  public static String serialize(Node root) {
    if(root == null)
        return "";
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }
  
  public static void serialize(Node root, StringBuilder sb) {
    sb.append(root.val + " ");
    for(Node child : root.children)
    {
        serialize(child, sb);
    }
    sb.append("null ");
  }

  // Decodes your encoded data to tree.
  public static Node deserialize(String str) {
      if(str.length() == 0)
        return null;
    String[] arr = str.split(" ");
    
    Stack<Node> st = new Stack<>();
    for(int i = 0; i < arr.length-1; i++)
    {
       String s = arr[i];
       if(s.equals("null"))
       {
           Node node = st.pop();
           st.peek().children.add(node);
       }
       else
       {
           Node node = new Node(Integer.parseInt(s));
           st.push(node);
       }
    }
    return st.pop();
  }

  // input_Section=================================================
  public static void display(Node node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append(node.val + " -> ");
    for (Node child : node.children) {
      sb.append(child.val + " ");
    }
    System.out.println(sb.toString());

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node createTree(String[] arr) {
    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length - 1; i++) {
      String s = arr[i];
      if (s.equals("null")) {
        Node node = st.pop();
        st.peek().children.add(node);
      } else {
        Node node = new Node(Integer.parseInt(s));
        st.push(node);
      }
    }

    return st.size() != 0 ? st.pop() : null;
  }

  public static void solve() {
    String str = scn.nextLine();
    String[] arr = str.split(" ");

    Node root = createTree(arr);
    String s = serialize(root);
    display(deserialize(s));
  }

  public static void main(String[] args) {
    solve();
  }
}
