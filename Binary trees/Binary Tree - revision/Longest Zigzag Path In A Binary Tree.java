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
    
    public static class Pair{
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen = 0;
    }
    
    public static Pair longestZigZagPath_(TreeNode root)
    {
        if(root == null)
            return new Pair();
            
        Pair left = longestZigZagPath_(root.left);
        Pair right = longestZigZagPath_(root.right);
        
        Pair ans = new Pair();
        
        ans.maxLen = Math.max(Math.max(left.maxLen, right.maxLen) , Math.max(left.backwardSlope, right.forwardSlope) + 1);
        
        ans.forwardSlope = left.backwardSlope + 1;
        ans.backwardSlope = right.forwardSlope + 1;
        
        return ans;
       
    }

    public static int longestZigZagPath(TreeNode root) {
        if(root == null)
            return 0;
        Pair p = longestZigZagPath_(root);
        
        return p.maxLen;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
