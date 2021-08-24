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
    
    public static class vPair{
        
        TreeNode node;
        int hl;
        
        vPair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        if(root == null)
        return null;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<vPair> q = new LinkedList<>();
        q.add(new vPair(root, 0));
        
        int maxhl = 0;
        int minhl = 0;
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                vPair n = q.removeFirst();
                
                maxhl = Math.max(n.hl, maxhl);
                minhl = Math.min(n.hl, minhl);
                
                map.putIfAbsent(n.hl, new ArrayList<>());
                map.get(n.hl).add(n.node.val);
                if(n.node.left != null)
                {
                    q.add(new vPair(n.node.left, n.hl - 1));
                }
                if(n.node.right != null)
                {
                    q.add(new vPair(n.node.right, n.hl + 1));
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = minhl; i <= maxhl; i++)
        {
            ans.add(map.get(i));
        }
        
    return ans;
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
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
