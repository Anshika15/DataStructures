/*

Unique Binary Search Trees 2

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. 
Return the answer in any order.

*/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        
       return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end)
        {
            res.add(null);
            return res;
        }
        
        for(int i = start; i <= end; i++)
        {
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);
            /* each bst of left will connect with right bst*/
            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
