/*

Add One Row to Tree

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

*/
class Solution {
    /* public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(root == null)
            return null;
        if(depth == 1)
        {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(depth-- > 2)
        {
            LinkedList<TreeNode> temp = new LinkedList<>();
            
            while(q.size() > 0)
            {
                TreeNode rem = q.removeFirst();
                if(rem.left != null)
                    temp.add(rem.left);
                if(rem.right != null)
                    temp.add(rem.right);
            }
            q = temp;
            temp = new LinkedList<>();
        }
        
        while(q.size() > 0)
        {
            TreeNode rem = q.removeFirst();
            
            TreeNode node = rem.left;
            rem.left = new TreeNode(val);
            rem.left.left = node;
            
            node = rem.right;
            rem.right = new TreeNode(val);
            rem.right.right = node;
            
        }
        return root;
        
    } */
    
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1)
        {
            return new TreeNode(v, root, null);
        }
        if(d == 2)
        {
            root.left = new TreeNode(v, root.left, null);
            root.right =  new TreeNode(v, null, root.right);
        }
        else
        {
            if(root.left != null)
                addOneRow(root.left, v, d-1);
            if(root.right != null)
                addOneRow(root.right, v, d-1);
        }
        
        return root;
    }
}
