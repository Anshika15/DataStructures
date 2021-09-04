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
    
    static class Pair{
        TreeNode node;
        int hl;
        
        Pair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
    }
    
    public static void width(TreeNode root, int hl, int[] ans)
    {
        if(root == null)
            return;
        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);
        
        width(root.left, hl-1, ans);
        width(root.right, hl+1, ans);
    }

    public static ArrayList<Integer> BottomView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
        return list;
        
        int[] wid = new int[2];
        width(root, 0, wid);
        int len = wid[1] - wid[0] + 1;
        for(int i = 0; i < len; i++)
        {
            list.add(0);
        }
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Math.abs(wid[0])));
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0){
            Pair rem = q.removeFirst();
            list.set(rem.hl, rem.node.val);
            if(rem.node.left != null)
            {
                q.add(new Pair(rem.node.left, rem.hl-1));
            }
            if(rem.node.right != null)
            {
                q.add(new Pair(rem.node.right, rem.hl+1)); 
            }
            }
            
        }
        
        return list;

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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
