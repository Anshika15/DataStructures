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
  
  /* using dfs */
  
  public static ArrayList<Integer> diagonalOrderSum(TreeNode root)
  {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if(root == null)
        return res;
    dfs(root, 0, res);
    return res;
  }
  
  public static void dfs(TreeNode root, int i, ArrayList<Integer> res)
  {
      if(root == null)
        return;
      if(res.size() == i)
        res.add(0);
      res.set(i, res.get(i)+root.val);
      dfs(root.left, i+1, res);
      dfs(root.right, i, res);
  }

    /* using bfs */
    
 /* public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {

    ArrayList<Integer> res = new ArrayList<Integer>();
    if(root == null)
        return res;
        
    LinkedList<TreeNode> q = new LinkedList<>();
    q.addLast(root);
    
    while(q.size() > 0)
    {
        int size = q.size();
        int sum = 0;
      
        while(size-- > 0)
        {
            TreeNode rem = q.removeFirst();
            while(rem != null)
            {
                sum += rem.val;
                if(rem.left != null)
                q.addLast(rem.left);
                rem = rem.right;
            }
        }
        res.add(sum);
    }
    
    
    return res;
  }
  */

  // input_section=================================================

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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}

