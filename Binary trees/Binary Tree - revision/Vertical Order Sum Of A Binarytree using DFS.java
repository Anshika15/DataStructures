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
    
    public static void width_(TreeNode root, int hl, int[] ans)
    {
        if(root == null)
            return;
        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);
        
        width_(root.left, hl-1, ans);
        width_(root.right, hl+1, ans);
    }
    
    public static class Pair{
        TreeNode node;
        int hl;
        
        Pair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
    }
    
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
            
        int[] width = new int[2];
        width_(root, 0, width);
        
        int len = width[1] - width[0] + 1;
        
        for(int i = 0; i < len; i++)
        {
            list.add(0);
        }
        
        dfs(root, Math.abs(width[0]), list);
        
        return list;
    }
    
    public static void dfs(TreeNode root, int hl, ArrayList<Integer> list)
    {
        if(root == null)
        {
           return; 
        }
        
        list.set(hl, list.get(hl) + root.val);
        
        dfs(root.left, hl-1, list);
        dfs(root.right, hl+1, list);
        
    }


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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}
