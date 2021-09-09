/*

All Nodes Distance K In Binary Tree

1. Given the root of a binary tree.
2. The value of a target node target, and an integer k.
3. You have return an array of the values of all nodes that have a distance k from the target node.

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
  
  public static void kLevelDown(TreeNode root, int k, TreeNode blocker, ArrayList<Integer> res)
  {
      if(root == null || k < 0 || blocker == root)
      {
          return;
      }
      if(k == 0)
      {
          res.add(root.val);
          return;
      }
      kLevelDown(root.left, k-1, blocker, res);
      kLevelDown(root.right, k-1, blocker, res);
  }
  
  public static int distanceK(TreeNode root, int target, int k, ArrayList<Integer> res)
  {
      if(root == null)
      {
          return -1;
      }
      
      if(root.val == target)
      {
        kLevelDown(root, k - 0, null, res); 
        return 1;
      }
      
      int ldis = distanceK(root.left, target, k, res);
      
      if(ldis != -1)
      {
        kLevelDown(root, k - ldis, root.left, res);
        return ldis + 1;
      }
      
      int rdis = distanceK(root.right, target, k, res);
      
      if(rdis != -1)
      {
        kLevelDown(root, k - rdis, root.right, res);
        return rdis + 1;
      }
      
      return -1;
  }

  /* without using extra space of root to node path */
  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    distanceK(root, target, k, result);
    return result;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
