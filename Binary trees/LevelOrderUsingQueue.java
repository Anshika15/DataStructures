import java.util.*;

public class LevelOrderUsingQueue {
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
		
		if (root != null)
		{
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (q.size() != 0)
			{
				Node temp = q.poll();
				System.out.print(temp.key + " ");
				if(temp.left != null)
				{
					q.add(temp.left);
				}
				if(temp.right != null)
				{
					q.add(temp.right);
				}
					
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderUsingQueue tree = new LevelOrderUsingQueue();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.level();


	}

}

