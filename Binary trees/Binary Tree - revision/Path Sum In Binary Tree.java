/* 

Path Sum In Binary Tree

1. You are given a partially written function to solve.
2. You are required to complete the body of hasPathSum function. The function is expected to return boolean value depending upon root-to-leaf paths where path sum equals targetSum.
3. Input and Output is managed for you.

*/

import java.util.Scanner;

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

  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null)
    return false;
    return hasPathSum(root, targetSum, 0);
  }

  public static boolean hasPathSum(TreeNode root, int target, int sum)
  {
    if(root == null)
      return false;
    if(root.left == null && root.right == null)
    {
      if(root.val+sum == target)
        return true;
      return false;
    }
    return hasPathSum(root.left, target, sum+root.val) || hasPathSum(root.right, target, sum+root.val);

    
  }

  // input_Section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }

    TreeNode node = new TreeNode(arr[IDX[0]++]);
    node.left = createTree(arr, IDX);
    node.right = createTree(arr, IDX);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    int tar = scn.nextInt();
    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(hasPathSum(root, tar));
  }

  public static void main(String[] args) {
    solve();
  }
}
