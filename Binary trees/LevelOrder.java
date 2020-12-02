import java.util.*;
public class LevelOrder {
	Node root;
	static class Node{
		Node left, right;
		int key;
		Node(int data)
		{
			key = data;
			left = right = null;
		}
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
	
	void level()
	{
		for(int i = 1; i <= height(root); i++)
		{
			printLevel(root, i);
		}
	}
	
	void printLevel(Node root, int i)
	{
		if(root != null)
		{
			if(i == 1)
				System.out.print(root.key + " ");
			else
			{
				printLevel(root.left, i-1);
				printLevel(root.right, i-1);	
			}
		}
	}

	int height(Node root)
	{
		return heightRec(root);
	}
	
	int heightRec(Node root)
	{
		if(root == null)
			return 0;
		else
		{
			int l = heightRec(root.left);
			int r = heightRec(root.right);
			if(l > r)
				return l+1;
			else
				return r+1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrder tree = new LevelOrder();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.level();

	}

}

