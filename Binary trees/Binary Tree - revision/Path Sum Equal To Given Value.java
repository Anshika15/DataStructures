/* 

1. Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
2. The path does not need to start or end at the root or a leaf,path can start from any where but it must go downwards

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

   public static int pathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return 0;
        // find the pathSum from current root and also check for left and right tree
        return pathSum_(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        
    }
    
    public static int pathSum_(TreeNode root, int targetSum)
    {
        if(root == null)
            return 0;
            
        // if we got our path sum increase it by one else check on other subtrees present
        if(root.val == targetSum)
            return 1 + pathSum_(root.left, targetSum - root.val) + pathSum_(root.right, targetSum - root.val);
        else
            return 0 + pathSum_(root.left, targetSum - root.val) + pathSum_(root.right, targetSum - root.val);
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
    int tar = scn.nextInt();

    int ans = pathSum(root, tar);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}
