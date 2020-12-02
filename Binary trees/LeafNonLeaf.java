import java.util.LinkedList;
import java.util.Queue;

public class LeafNonLeaf {
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
	LinkedList<Integer> l1 = new LinkedList<Integer>();
	LinkedList<Integer> l2 = new LinkedList<Integer>();
	public int leaf()
	{
		return leafRec(root);
	}

	public int leafRec(Node root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
		{
			l1.add(root.key);
			return 1;
		}
		else
		
			return leafRec(root.left) + leafRec(root.right);
	} 
	
	int nonleaf()
	{
		return nonleafRec(root);
	}
	
	int nonleafRec(Node root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 0;
		else
		{
			l2.add(root.key);
			return 1 + nonleafRec(root.left) + nonleafRec(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeafNonLeaf obj = new LeafNonLeaf();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.insert(6);
		int l = obj.leaf();
		int nl = obj.nonleaf();
		System.out.println("Number of leaf Nodes are: " + l);
		System.out.print("Leaf Nodes are: " + obj.l1);
		System.out.println("\nNumber of Non-leaf nodes are: " + nl);
		System.out.print("Non - Leaf Nodes are: " + obj.l2);
	}

}

