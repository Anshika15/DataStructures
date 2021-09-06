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
    
     public static TreeNode constructFromInOrder(int[] inOrder, int start, int end) {
         if(start > end)
            return null;
         int mid = start + (end - start)/2;
         TreeNode node = new TreeNode(inOrder[mid]);
         
         node.left = constructFromInOrder(inOrder, start, mid-1);
         node.right = constructFromInOrder(inOrder, mid+1, end);
         
         return node;
    }
    

    public static TreeNode constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder(inOrder, 0, n-1);
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
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
