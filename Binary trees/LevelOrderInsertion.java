import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderInsertion {
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
	
	
	public void insert(int data)
	{
		if(root == null)
		{
			root = new Node(data);
		}
		else
		{
			Queue<Node>  q = new LinkedList<Node>();
			q.add(root);
			while(q.size() != 0)
			{
				Node temp = q.poll();
				if(temp.left == null)
				{
					temp.left = new Node(data);
					break;
				}
				else
					q.add(temp.left);
				
				if(temp.right == null)
				{
					temp.right = new Node(data);
					break;
				}
				else
					q.add(temp.right);
			}
		}
		
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
		LevelOrderInsertion tree = new LevelOrderInsertion();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.level();


	}

}

