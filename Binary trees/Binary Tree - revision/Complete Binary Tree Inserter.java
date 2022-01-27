/*
 Complete Binary Tree Inserter

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.

Implement the CBTInserter class:

CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, and returns the value of the parent of the inserted TreeNode.
TreeNode get_root() Returns the root node of the tree.

*/
class CBTInserter {
    
    TreeNode head = null;
    TreeNode nextInsertionPointer = null;
    LinkedList<TreeNode> q;
    public CBTInserter(TreeNode root) {
        
        head = root;
        q = new LinkedList<>();
        q.add(root);
        while(true)
        {
            TreeNode node = q.getFirst();
            if(node.left != null)
            {
                q.add(node.left);
            }
            else
            {
                nextInsertionPointer = node;
                break;
            }
            
            if(node.right != null)
            {
                q.add(node.right);
            }
            else
            {
                nextInsertionPointer = node;
                break;
            }
            q.removeFirst();
        }
        
    }
    
    public int insert(int val) {
        int res = nextInsertionPointer.val;
        if(nextInsertionPointer.left == null)
        {
            TreeNode node = new TreeNode(val);
            nextInsertionPointer.left = node;
            q.add(node);
        }
        else
        {
            TreeNode node = new TreeNode(val);
            nextInsertionPointer.right = node;
            q.removeFirst();
            q.add(node);
            nextInsertionPointer = q.getFirst();
            
        }
        return res;
    }
    
    public TreeNode get_root() {
        return head;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
