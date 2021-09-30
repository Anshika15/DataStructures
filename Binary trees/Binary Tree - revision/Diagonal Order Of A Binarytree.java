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
    

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        if(root == null)
        return l;
     
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        
        while(q.size() > 0)
        {
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                while(rem != null)
                {
                    ans.add(rem.val);
                    if(rem.left != null)
                        q.addLast(rem.left);
                    rem = rem.right;
                }
            }
            l.add(ans);
        }
        return l;
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

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
