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
    
    public static class Pair implements Comparable<Pair>{
        TreeNode node;
        int hl;
        
        Pair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
        
        public int compareTo(Pair p)
        {
            return this.node.val - p.node.val;
        }
    }
    
    public static void width_(TreeNode root, int hl, int[] ans)
    {
        if(root == null)
            return;
        
        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);
        
        width_(root.left, hl-1, ans);
        width_(root.right, hl+1, ans);
        
        
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        int width[] = new int[2];
        width_(root, 0, width);
        
        int len = width[1] - width[0] + 1;
        
        for(int i = 0; i < len; i++)
            ans.add(new ArrayList<>());
        
        PriorityQueue<Pair> parentQ = new PriorityQueue<>();
        PriorityQueue<Pair> childQ = new PriorityQueue<>();
        
        parentQ.add(new Pair(root, Math.abs(width[0])));
        
        while(parentQ.size() > 0)
        {
            int size = parentQ.size();
            while(size-- > 0)
            {
                Pair rem = parentQ.remove();
                
                TreeNode node = rem.node;
                int hl = rem.hl;
                
                ans.get(hl).add(node.val);
                
                if(node.left != null)
                {
                    childQ.add(new Pair(node.left, hl-1));
                }
                
                if(node.right != null)
                {
                    childQ.add(new Pair(node.right, hl+1));
                }
            }
            
            
            PriorityQueue<Pair> pq = parentQ;
            parentQ = childQ;
            childQ = pq;
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
