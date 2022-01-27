/*

Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

*/
class Solution {
    public int goodNodes(TreeNode root) {
        
        
        if(root == null)
            return 0;
        return solution(root, Integer.MIN_VALUE);
        
    }
    
    public int solution(TreeNode node, int max)
    {
        if(node == null)
            return 0;
        int res = 0;
        if(max <= node.val)
            res = 1;
        max = Math.max(max, node.val);
        int left = solution(node.left, max);
        int right = solution(node.right, max);
        
        res += left+right;
        
        return res;
    }
}
