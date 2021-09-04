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
    
    
    public static TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        
        if(inStart > inEnd)
            return null;
            
        int idx = inStart;
        while(inorder[idx] != preorder[preStart])
            idx++;
        int countElements = idx - inStart;
        
        
        TreeNode node = new TreeNode(preorder[preStart]);
        
        node.left = buildTree(preorder, inorder, inStart, idx - 1,preStart + 1, preStart + countElements);
        node.right = buildTree(preorder, inorder, idx + 1, inEnd ,preStart + countElements + 1, preEnd);
        
        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
