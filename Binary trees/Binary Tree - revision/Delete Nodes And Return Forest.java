/*

Delete Nodes And Return Forest

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

*/
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        /*
        we will use postorder traversal as if we use any other traversal and put null at the found value we will not be able to traverse the rest of subtree
        */
        
        HashSet<Integer> set = new HashSet<>();
        for(int val: to_delete)
        {
            set.add(val);
        }
        
        List<TreeNode> res = new ArrayList<>();
        
        solution(root, set, res);
        if(!set.contains(root.val))
            res.add(root);
        return res;
    }
    
    public TreeNode solution(TreeNode root, HashSet<Integer> set, List<TreeNode> res)
    {
        if(root == null)
            return null;
        root.left = solution(root.left, set, res);
        root.right = solution(root.right, set, res);
        
        if(set.contains(root.val))
        {
            if(root.left != null)
            {
                res.add(root.left);
            }
            if(root.right != null)
            {
                res.add(root.right);
            }
            return null;
        }
        return root;
    }
}
