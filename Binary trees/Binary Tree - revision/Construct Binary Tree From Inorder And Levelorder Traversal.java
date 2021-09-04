import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val;
    TreeNode left = null, right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }


  public static TreeNode buildTree(int[] inorder, int[] levelOrder, int inStart, int inEnd){
    
    if(inEnd < inStart)
        return null;
        
    TreeNode node = new TreeNode(levelOrder[0]);
    if(levelOrder.length == 1)
        return node;
    
    int idx = inStart;
    while(inorder[idx] != levelOrder[0])
        idx++;
    HashSet<Integer> set = new HashSet<>();
    for(int i = inStart; i < idx; i++)
        set.add(inorder[i]);
        
    int leftLevelOrder[] = new int[idx - inStart];
    int rightLevelOrder[] = new int[inEnd - idx];
    int ls = 0;
    int lr = 0;
    for(int i = 1; i < levelOrder.length; i++)
    {
        if(set.size() != 0 && set.contains(levelOrder[i]))
        {
           leftLevelOrder[ls++] = levelOrder[i];
           set.remove(levelOrder[i]);
        }
        else
        {
            rightLevelOrder[lr++] = levelOrder[i];
        }
    }
    
    node.left = buildTree(inorder, leftLevelOrder, inStart, idx-1);
    node.right = buildTree(inorder, rightLevelOrder, idx+1, inEnd);
    
    return node;
      
  }
  
  
  public static TreeNode buildTree(int[] inorder, int[] levelOrder){
    
    int n = inorder.length;
    return buildTree(inorder, levelOrder, 0, n-1);
      
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

public static void solve() {
  int n = scn.nextInt();

  int[] InOrder = new int[n];
  for (int i = 0; i < n; i++)
    InOrder[i] = scn.nextInt();

  int[] LevelOrder = new int[n];
  for (int i = 0; i < n; i++)
    LevelOrder[i] = scn.nextInt();

  TreeNode root = buildTree(InOrder, LevelOrder);
  display(root);
}

public static void main(String[] args) {
  solve();
}

}
