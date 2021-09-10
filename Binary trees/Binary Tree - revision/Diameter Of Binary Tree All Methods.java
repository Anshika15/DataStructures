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
  
  /* O(n^2) Complexity */
 
  /* 
  public static int height(TreeNode root)
  {
      return root == null ? -1 : Math.max(height(root.left), height(root.right))+1;
  }
  
  public static int diameter(TreeNode node)
  {
      if(node == null)
        return 0;
      int ld = diameter(node.left);
      int rd = diameter(node.right);
      
      int lh = height(node.left);
      int rh = height(node.right);
      
      int myDia = lh + rh + 2;
      return Math.max(myDia, Math.max(ld, rd));
  }
  
  */
  
  /* solution2 */
 /* public static int[] diameter(TreeNode root)
  {
      if(root == null)
        return new int[]{0, -1};
      int lres[] = diameter(root.left); // 0 index -> diameter, 1 index -> height
      int rres[] = diameter(root.right);
      
      int myAns[] = new int[2];
      myAns[0] = Math.max(Math.max(lres[0], rres[0]), lres[1] + rres[1] + 2);
      myAns[1] = Math.max(lres[1], rres[1])+1;
      
      return myAns;
  }

  public static int diameterOfBinaryTree(TreeNode root) {
    int ans[] = diameter(root);
    
    return ans[0];
  }
*/

    static int maxDia = 0;
    public static int diameter(TreeNode root)
    {
        if(root == null)
        {
            return -1; 
        }
        
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        
        maxDia = Math.max(maxDia, lh+rh+2);
        return Math.max(lh, rh) + 1;
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        int ans = diameter(root);
    
        return maxDia;
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
    System.out.println(diameterOfBinaryTree(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
