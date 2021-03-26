
public class AvlTree {
	static TreeNode tree;
	
	static class TreeNode{
		int val;
		TreeNode left, right;
		int height;
		TreeNode(int v)
		{
			val = v;
			height = 1;
		}
	}
	
	static void insert(int v)
	{
		tree = insertRec(tree, v);
	}
	
	static TreeNode insertRec(TreeNode root, int val)
	{
		if(root == null)
			return (new TreeNode(val));
		if(root.val > val)
		{
			root.left = insertRec(root.left, val);
		}
		else if(root.val < val)
		{
			root.right = insertRec(root.right, val);
		}
		else
		{
			return root;
		}
		
		root.height = 1 + Math.max(heightTree(root.left), heightTree(root.right)); 
		
		
		int balance = balanceFactor(root);
		
		//int state = findState(root);
		if(balance > 1)
		{
			if(val > root.left.val)
			{
				// lr rotation
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
			else if(val < root.left.val)
			{
				// rr rotation
				return rightRotate(root);
			}
		}
		
		if(balance < -1)
		{
			if(val < root.right.val)
			{
				// rl rotation
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
			else if(val > root.right.val)
			{
				// ll rotation
				return leftRotate(root);
			}
		}
		return root;
	}
	
	static TreeNode leftRotate(TreeNode root)
	{
		TreeNode r = root.right;
		root.right = r.left;
		r.left = root;
		
		r.height = Math.max(heightTree(r.left), heightTree(r.right)) + 1;
		root.height = Math.max(heightTree(root.left), heightTree(root.right)) + 1;
		return r;
	}
	
	static TreeNode rightRotate(TreeNode root)
	{
		TreeNode r = root.left;
		root.left = r.right;
		r.right = root;
		
		r.height = Math.max(heightTree(r.left), heightTree(r.right)) + 1;
		root.height = Math.max(heightTree(root.left), heightTree(root.right)) + 1;
		return r;
	}
	
	static int balanceFactor(TreeNode root)
	{
		if(root == null)
			return 0;
		return heightTree(root.left) - heightTree(root.right);
	}

	public static void main(String[] args) {
		
		insert(10);
		insert(20);
		insert(30);
		insert(40);
		insert(50);
		insert(25);
		print(tree);

	}
	
	static void print(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.val + " ");
			print(root.left);
			print(root.right);
		}
	}
	
	static int heightTree(TreeNode root)
	{
		if(root != null)
		{
			return root.height;
		}
		return 0;
	}

}

