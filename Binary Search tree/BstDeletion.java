import java.util.Scanner;


public class BstDeletion {
	
	class Node{
		Node(int val)
		{
			data = val;
			left = right = null;
		}
		int data;
		Node left, right;
	}
	
	Node root;
	
	BstDeletion()
	{
		root = null;
	}
	
	void insert(int data)
	{
		root = insertRec(root, data);
	}
	
	Node insertRec(Node root,int data)
	{
		if(root == null)
		{
			root = new Node(data);
			return root;
		}
		else
		{
			if(root.data > data)
			{
				root.left = insertRec(root.left, data);
			}
			else if(root.data <= data)
			{
				root.right = insertRec(root.right, data);
			}
		}
		return root;
	}
	
	void print()
	{
		printRec(root);
	}
	
	void printRec(Node root)
	{
		if(root != null)
		{
			printRec(root.left);
			System.out.print(root.data + " ");
			printRec(root.right);
		}
	}
	
	void delete(int data)
	{
		root = deleteRec(root, data);
	}

	Node deleteRec(Node root, int data)
	{
			if(root == null)
			{
				return root;
			}
		
			if(root.data > data)
			{
				root.left =  deleteRec(root.left, data);
			}
			else if(root.data < data)
			{
				root.right = deleteRec(root.right, data);
			}	
			else
			{
				if(root.left == null && root.right == null)
				{
					return  null;
				}
				else if(root.left == null)
				{
					return root.right;
				}
				else if(root.right == null)
				{
					return root.left;
				}
				else if(root.left != null && root.right != null)
				{
					int min = minFunc(root.right);
					root.data = min;
					root.right = deleteRec(root.right, min);
				}
			}
		
		return root;
	}
	
	int minFunc(Node root)
	{
		int min = root.left.data;
		while(root != null)
		{
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BstDeletion obj = new BstDeletion();
		obj.insert(20);
		obj.insert(10);
		obj.insert(50);
		obj.insert(60);
		obj.insert(5);
		obj.insert(2);	
		obj.insert(25);
		System.out.print("Inorder traversal of tree before deletion: ");
		obj.print();
		System.out.println();
		System.out.print("Enter the element you want to delete: ");
		int n = s.nextInt();
		obj.delete(n);
		System.out.print("Inorder traversal of tree after deletion: ");
		obj.print();
	}

}

