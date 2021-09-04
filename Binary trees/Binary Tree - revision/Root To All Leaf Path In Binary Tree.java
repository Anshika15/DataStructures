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
  
  public static void rootToAllLeafPath_(ArrayList<ArrayList<Integer>> list, TreeNode root, ArrayList<Integer> l)
  {
      if(root == null)
        return;
        
      l.add(root.val);
      
      if(root.left == null && root.right == null)
      {
          list.add(new ArrayList<>(l));
      }
      
      rootToAllLeafPath_(list, root.left, l);
      rootToAllLeafPath_(list, root.right, l);
      l.remove(l.size() - 1);
      
  }

  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
    // write your code.
    
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> l = new ArrayList<>();
    rootToAllLeafPath_(list, root, l);
    return list;
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

    ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> al : ans) {
      for (Integer ele : al)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
