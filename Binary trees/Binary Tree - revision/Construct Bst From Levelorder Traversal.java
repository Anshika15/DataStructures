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

    public static TreeNode constructBSTFromLevelOrder(int LevelOrderData, TreeNode node) {
        if(node == null)
        {
            node = new TreeNode(LevelOrderData);
         
            return node;
        }
        
        if(LevelOrderData <= node.val)
            node.left = constructBSTFromLevelOrder(LevelOrderData, node.left);
        else
            node.right = constructBSTFromLevelOrder(LevelOrderData, node.right);
            
        return node;
    }
    
    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        TreeNode node = null;
        
        for(int i = 0; i < LevelOrder.length; i++)
            node = constructBSTFromLevelOrder(LevelOrder[i], node);
            
        return node;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
