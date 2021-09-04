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
    
    public static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
      
       if(inEnd < inStart)
        return null;
        
        int idx = inStart;
        
        while(inorder[idx] != postorder[postEnd])
            idx++;
        int countElements = idx - inStart;
        
        TreeNode node = new TreeNode(postorder[postEnd]);
        
        
        node.left = buildTree(inorder, postorder, inStart, idx - 1, postStart, postStart + countElements - 1);
        node.right = buildTree(inorder, postorder, idx+1, inEnd, postStart + countElements, postEnd - 1);
        
        return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = inorder.length;
        return buildTree(inorder, postorder, 0, n-1, 0, n-1);
        //return null;
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
