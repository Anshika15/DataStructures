import java.util.*;

public class BstSearch {
	
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
	
	BstSearch()
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
	
	boolean search(int data)
	{
		Node res = searchRec(root, data);
		if(res != null)
		{
			return true;
		}
		return false;
	}

	Node searchRec(Node root, int data)
	{
		if(root != null)
		{
			if(root.data == data)
			{
				return root;
			}
			else if(root.data > data)
			{
				return searchRec(root.left, data);
			}
			else if(root.data <= data)
			{
				return searchRec(root.right, data);
			}	
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BstSearch obj = new BstSearch();
		obj.insert(20);
		obj.insert(10);
		obj.insert(50);
		obj.insert(60);
		obj.insert(5);
		obj.insert(2);	
		obj.insert(25);
		//obj.print();
		
		System.out.print("Enter the element you want to search for: ");
		int n = s.nextInt();
		boolean ans = obj.search(n);
		if(ans == true)
		{
			System.out.println("Element " + n + " is in the tree");
		}
		if(ans == false)
		{
			System.out.println("Element " + n + " is not in the tree");
		}
	}

}

