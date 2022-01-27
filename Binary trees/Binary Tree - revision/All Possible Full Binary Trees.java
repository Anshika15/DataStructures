/*

All Possible Full Binary Trees

Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        
        /* all nodes can not become root as there should be odd nodes in left subtree and odd nodes in right subtree so that it becomes full binary tree */
        /* if n is even then we cannot create a full binary tree */
        
        List<TreeNode> res = new ArrayList<>();
        if(n%2 == 0)
            return res;
        if(n == 1)
        {
            res.add(new TreeNode(0));
            return res;
        }
        
        for(int i = 1; i < n; i+=2)
        {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            
            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        
        return res;
    }
}
