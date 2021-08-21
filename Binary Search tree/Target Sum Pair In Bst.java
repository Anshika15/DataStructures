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
  
  public static void inorder(Node node, ArrayList<Integer> list)
  {
      if(node == null)
        return;
      inorder(node.left, list);
      list.add(node.data);
      inorder(node.right, list);
      
  }
  
  public static void targetSumPair(Node node, int data)
  {
      if(node == null)
        return;
      ArrayList<Integer> list = new ArrayList<>();
      inorder(node, list);
      
      int l = 0;
      int r = list.size() - 1;
      
      while(l < r)
      {
          if(list.get(l) + list.get(r) < data)
          {
              l++;
          }
          else if(list.get(l) + list.get(r) > data)
          {
              r--;
          }
          else
          {
              System.out.println(list.get(l) + " " + list.get(r));
              l++;
              r--;
          }
      }
  }
  
  public static class ITPair{
      Node node;
      int state;
      
      ITPair(Node node, int state)
      {
          this.node = node;
          this.state = state;
      }
  }
  
  public static void bestApproach(Node node, int target)
  {
      Stack<ITPair> s1 = new Stack<ITPair>();
      Stack<ITPair> s2 = new Stack<ITPair>();
      
      s1.push(new ITPair(node, 0));
      s2.push(new ITPair(node, 0));
      
      Node left = getNextNodeFromLeft(s1);
      Node right = getNextNodeFromRight(s2);
      
      while(left.data < right.data)
      {
          if(left.data + right.data < target)
          {
              left = getNextNodeFromLeft(s1);
          }
          else if(left.data + right.data > target)
          {
              right = getNextNodeFromRight(s2);
          }
          else{
              System.out.println(left.data + " " + right.data);
              left = getNextNodeFromLeft(s1);
              right = getNextNodeFromRight(s2);
          }
      }
  }

    
  public static Node getNextNodeFromLeft(Stack<ITPair> s)
  {
      /*normal inorder */
      while(s.size() > 0)
      {
        ITPair top = s.peek();
        
        if(top.state == 0)
        {
           if(top.node.left != null)
           {
               s.add(new ITPair(top.node.left, 0));  
           }
           top.state++;
        }
        else if(top.state == 1)
        {
            if(top.node.right != null)
            {
               s.add(new ITPair(top.node.right, 0)); 
            }
            top.state++;
            return top.node;
        }
        else if(top.state == 2)
        {
            s.pop();
        }
          
      }
      return null;
      
  }
  
  public static Node getNextNodeFromRight(Stack<ITPair> s)
  {
      /*reverse inorder */
      while(s.size() > 0)
      {
        ITPair top = s.peek();
        
        if(top.state == 0)
        {
           if(top.node.right != null)
           {
               s.add(new ITPair(top.node.right, 0));  
           }
           top.state++;
        }
        else if(top.state == 1)
        {
            if(top.node.left != null)
            {
               s.add(new ITPair(top.node.left, 0)); 
            }
            top.state++;
            return top.node;
        }
        else if(top.state == 2)
        {
            s.pop();
        }
          
      }
      return null;
      
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    // write your code here
    bestApproach(root, data);
    
    // targetSumPair(root, data);
  }

}
