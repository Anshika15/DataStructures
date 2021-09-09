/*

Maximum Width Of Binary Tree

1. Given the root of a binary tree, return the maximum width of the given tree.
2. The maximum width of a tree is the maximum width among all levels.
3. The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.


*/
import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  public static class Pair{
      TreeNode node;
      int l;
      
      Pair(TreeNode node, int l)
      {
          this.node = node;
          this.l = l;
      }
  }

  public static int widthOfBinaryTree(TreeNode root) {
      
      int max = 0;
      LinkedList<Pair> q = new LinkedList<>();
      q.add(new Pair(root, 0));
      while(q.size() > 0)
      {
          int size = q.size();
          int lm = q.getFirst().l;
          int rm = q.getFirst().l;
          while(size-- > 0)
          {
              Pair rem = q.removeFirst();
              rm = rem.l;
              if(rem.node.left != null)
              {
                  q.add(new Pair(rem.node.left, rem.l * 2+1));
              }
              if(rem.node.right != null)
              {
                  q.add(new Pair(rem.node.right, rem.l* 2+2));
              }
              
              max = Math.max(max, rm - lm +1);
              
          }
      }
      
      return max;

  }

  // input_section=================================================

  public static void display(TreeNode node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);
  }

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}
