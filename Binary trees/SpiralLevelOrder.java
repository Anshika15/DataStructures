import java.util.*;
public class SpiralLevelOrder {
	Node root;
	class Node{
		int key;
		Node left,  right;
		Node(int data)
		{
			key = data;
			left = right = null;
		}
	}
	void insert(int data)
	{
		if(root == null)
			root = new Node(data);
		
		else
		{
			Queue<Node> q = new LinkedList<Node>();
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
	
	void print()
	{
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		while(stack1.size() != 0 || stack2.size() != 0)
		{
			while(stack1.size() != 0)
			{
				Node temp = stack1.pop();
				System.out.print(temp.key + " ");
				if(temp.right != null)
					stack2.push(temp.right);
				if(temp.left != null)
					stack2.push(temp.left);	
			}
			while(stack2.size() != 0)
			{
				Node temp = stack2.pop();
				System.out.print(temp.key + " ");
				if(temp.left != null)
					stack1.push(temp.left);
				if(temp.right != null)
					stack1.push(temp.right);	
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralLevelOrder tree = new SpiralLevelOrder();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.print();
	}

}

