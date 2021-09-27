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
  
  static class Pair{
      int nToNMaxSum = Integer.MIN_VALUE; // node to node max sum
      int rToNMaxSum = 0; // root to node max sum
  }
  
  public static int getmax(int... arr)
  {
      int maxSF = arr[0];
      for(int ele : arr)
        maxSF = Math.max(maxSF, ele);
      return maxSF;
  }
  public static Pair maxPathSum_(TreeNode root) {
      if(root == null)
        return new Pair();
        
      Pair lp = maxPathSum_(root.left);
      Pair rp = maxPathSum_(root.right);
      
      Pair myAns = new Pair();
      int rtnMax = Math.max(lp.rToNMaxSum, rp.rToNMaxSum) + root.val;
      int ntnMax = getmax(lp.nToNMaxSum, rp.nToNMaxSum, lp.rToNMaxSum + root.val + rp.rToNMaxSum, root.val, rtnMax);
      
      myAns.rToNMaxSum = Math.max(rtnMax, root.val);
      myAns.nToNMaxSum = ntnMax;
      return myAns;
  }

  public static int maxPathSum(TreeNode root) {
      if(root == null)
      return 0;
    Pair p = maxPathSum_(root);
    return p.nToNMaxSum;
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

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
