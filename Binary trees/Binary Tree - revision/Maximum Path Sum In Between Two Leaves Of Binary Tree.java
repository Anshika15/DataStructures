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
  
  public static class Pair{
      int nToLMaxSum = Integer.MIN_VALUE; // node to leaf path max sum
      int lToLMaxSum = Integer.MIN_VALUE; // leaf to leaf path max sum
      
      Pair(){}
      
      Pair(int nToLMaxSum, int lToLMaxSum)
      {
        this.nToLMaxSum = nToLMaxSum;
        this.lToLMaxSum = lToLMaxSum;
      }
  }
  
  public static Pair maxPathSum_(TreeNode root) {
    if(root == null)
    {
        return new Pair();
    }
    if(root.left == null && root.right == null)
    {
        /* it is a leaf node therefore, there will be only node to leaf path sum */
        Pair p = new Pair();
        p.nToLMaxSum = root.val;
        return p;
    }
    
    Pair lp = maxPathSum_(root.left);
    Pair rp = maxPathSum_(root.right);
    
    Pair myAns = new Pair();
    myAns.lToLMaxSum = Math.max(lp.lToLMaxSum, rp.lToLMaxSum);
    
    if(root.left != null && root.right != null)
    {
       myAns.lToLMaxSum = Math.max(myAns.lToLMaxSum , lp.nToLMaxSum + root.val + rp.nToLMaxSum); 
    }
    
    myAns.nToLMaxSum = Math.max(lp.nToLMaxSum, rp.nToLMaxSum) + root.val;
    return myAns;
  }

  public static int maxPathSum(TreeNode root) {
      
      Pair res = maxPathSum_(root);
      return res.lToLMaxSum;
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
