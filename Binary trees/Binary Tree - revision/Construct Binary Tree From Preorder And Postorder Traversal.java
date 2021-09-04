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
    
     public static TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
         
         if(preStart > preEnd)
            return null;
         
         TreeNode node = new TreeNode(pre[preStart]);
         if(preStart == preEnd)
            return node;
            
         int idx = postStart;
         while(post[idx] != pre[preStart+1])
            idx++;
         int count = idx - postStart + 1;
            
         node.left = constructFromPrePost(pre, post, preStart+1, preStart + count, postStart, idx );
         node.right = constructFromPrePost(pre, post, preStart + count + 1, preEnd, idx+1, postEnd);
         
         return node;
         
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        
        return constructFromPrePost(pre, post, 0, n-1, 0, n-1);
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

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
