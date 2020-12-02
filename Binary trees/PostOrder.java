import java.util.ArrayList;

class Node {
	int key;
	Node left , right;
	public Node(int data)
	{
		key = data;
		left = null;
		right = null;
	}
}

public class PostOrder {
	
	static Node root;
	
	PostOrder()
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
	
	void postorder()
	{
		printRec(root);
	}

	void printRec(Node root)
	{
		if(root != null) {
			printRec(root.left);
			printRec(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOrder tree = new PostOrder();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		
		tree.postorder();

	}

}

