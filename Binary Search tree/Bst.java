import java.util.*;
public class Bst {
	
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
	
	Bst()
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bst obj = new Bst();
		Scanner s = new Scanner(System.in);
		obj.insert(10);
		obj.insert(20);
		obj.insert(5);
		obj.insert(15);
		obj.print();
		

	}

}

