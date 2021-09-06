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
    
    public static int idx = 0;
    
    public static TreeNode bstFromPostorder(int[] postorder, int lr, int rr) {
        
        if(idx < 0 || postorder[idx] < lr || postorder[idx] > rr)
            return null;
            
        TreeNode node = new TreeNode(postorder[idx--]);
        node.right = bstFromPostorder(postorder, node.val, rr);
        node.left = bstFromPostorder(postorder, lr, node.val);
        return node;
    }

    public static TreeNode bstFromPostorder(int[] postorder) {
        idx = postorder.length - 1;
        return bstFromPostorder(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        int[] postorder = new int[n];
        for (int i = 0; i < n; i++)
            postorder[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(postorder);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
