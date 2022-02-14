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
    
    public static class Pair{
        TreeNode node = null;
        int hl = 0;
        
        Pair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
    }
    
    public static void width_(TreeNode root, int hl, int[] res)
    {
        if(root == null)
            return;
        res[0] = Math.min(res[0], hl);
        res[1] = Math.max(res[1], hl);
        
        width_(root.left, hl-1, res);
        width_(root.right, hl+1, res);
    }

    public static ArrayList<Integer> TopView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
        {
            return list;
        }
        int width[] = new int[2];
        width_(root, 0, width);
        
        int len = width[1] - width[0] + 1;

        for(int i = 0; i < len; i++)
            list.add(null);
            
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair(root, Math.abs(width[0])));
        
        while(q.size() != 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                TreeNode n = rem.node;
                int hl = rem.hl;
                if(list.get(hl) == null)
                {
                    list.set(hl, n.val);
                }
                if(rem.node.left != null)
                {
                    q.addLast(new Pair(n.left, hl - 1));
                }
                if(rem.node.right != null)
                {
                    q.addLast(new Pair(rem.node.right, rem.hl + 1));
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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
