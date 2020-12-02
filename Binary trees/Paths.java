import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class Paths {
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
	
	void path()
	{
		int[] arr = new int[1000];
		pathRec(root, arr, 0);
	}
	void pathRec(Node root, int[] arr, int l)
	{
		if(root == null)
			return;
		if(root != null)
		{
			arr[l] = root.key;
			l++;
			if(root.left == null && root.right == null)
			{
				print(arr, root, l);
			}
			else
			{
				pathRec(root.left, arr, l);
				pathRec(root.right, arr, l);
			}
		}
	}
	
	void print(int[] arr, Node root, int l)
	{
		System.out.print("path from root to leaf node " + root.key + " is: ");
		for(int i = 0; i < l; i++)
			System.out.print(arr[i] + " ");
		System.out.println("length of path is: "+ (l-1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paths obj = new Paths();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.insert(6);
		obj.insert(7);
		obj.insert(8);
		obj.insert(9);
		obj.insert(10);
		obj.insert(11);
		obj.insert(12);
		obj.path();

	}

}

