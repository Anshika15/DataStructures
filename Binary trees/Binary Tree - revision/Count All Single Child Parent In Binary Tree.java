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
  
  static int count = 0;

  public static void countExactlyOneChild(TreeNode root) {
    if(root == null || (root.left == null && root.right == null))
        return;
    
    if(root.left == null || root.right == null)
    {
        count++;
    }
    
    countExactlyOneChild(root.left);
    countExactlyOneChild(root.right);
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
    countExactlyOneChild(root);
    System.out.println(count);
  }

  public static void main(String[] args) {
    solve();
  }
}
