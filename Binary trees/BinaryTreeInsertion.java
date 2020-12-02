import java.util.*;

class Node{
	int key;
	Node left , right;
	public Node(int data)
	{
		key = data;
		left = null;
		right = null;
	}
}

public class BinaryTreeInsertion {
	
	static Node root;
	
	BinaryTreeInsertion()
	{
		root = null;
	}
	
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public void insert(int data)
	{
		arr.add(data);
		root = insertRec(root, 0);
	}
	
	public Node insertRec(Node root, int i)
	{
		if(i < arr.size())
		{
			Node temp = new Node(arr.get(i));
			root = temp;
			root.left = insertRec(root.left, 2 * i + 1);
			root.right = insertRec(root.right, 2 * i + 2);
		}
		return root;
	}
	
	void print()
	{
		printRec(root);
	}

	void printRec(Node root)
	{
		if(root != null) {
			printRec(root.left);
			System.out.print(root.key + " ");
			printRec(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInsertion tree = new BinaryTreeInsertion();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		
		tree.print();

	}

}

