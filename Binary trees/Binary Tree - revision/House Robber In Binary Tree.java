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
    
    public static class robbery{
        int withRobbery;
        int withoutRobbery;
        
    }
    
    public static robbery HouseRobber_(TreeNode root)
    {
        if(root == null)
            return new robbery();
        robbery rleft = HouseRobber_(root.left);
        robbery rright = HouseRobber_(root.right);
        
        robbery ans = new robbery();
        
        ans.withRobbery = rleft.withoutRobbery + root.val + rright.withoutRobbery;
        
        ans.withoutRobbery = Math.max(rleft.withoutRobbery, rleft.withRobbery) + Math.max(rright.withoutRobbery, rright.withRobbery);
        
        return ans;
    }

    public static int HouseRobber(TreeNode root) {
        if(root == null)
        return 0;
        
        robbery res = HouseRobber_(root);
        return Math.max(res.withRobbery, res.withoutRobbery);
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
