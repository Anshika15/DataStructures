/*
Even Odd Tree

A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        if(root == null)
            return true;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(q.size() > 0)
        {
            int size = q.size();
            int val = 0;
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                if(level%2 == 0) // check odd vals in strictly increasing
                {
                    if(rem.val%2 == 0)
                        return false;
                    
                    if(val != 0)
                    {
                        if(val >= rem.val)
                            return false;
                        val = rem.val;
                    }
                    else
                    {
                        val = rem.val;
                    }
                }
                else // check even vals in strictly decreasing
                {
                    if(rem.val%2 != 0)
                        return false;
                    
                    if(val != 0)
                    {
                        if(val <= rem.val)
                            return false;
                        val = rem.val;
                    }
                    else
                    {
                        val = rem.val;
                    }
                }
                
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            level++;
        }
        
        return true;
    }
}
