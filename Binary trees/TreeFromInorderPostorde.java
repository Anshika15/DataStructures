import java.util.*;

public class TreeFromInorderPostorder {
	static Node root;
	static class Node{
		Node left, right;
		int key;
		Node(int data)
		{
			key = data;
			left = right = null;
		}
	}
	static int index = 0;
	  static Node buildTree(int in[], int post[], int n)
	  {
	    index = n-1;
	    return build(in, post, 0, n-1);
	  }
	  static Node build(int in[], int post[], int start, int end)
	  {
	    if(start > end)
	      return null;
	    
	    Node n = new Node(post[index]);
	    index--;
	    
	    if(start == end)
	      return n;
	    
	    int iIndex = search(in, start, end, n.key);
		n.right = build(in, post, iIndex + 1, end);
		n.left = build(in, post, start, iIndex - 1);
	
	    return n;
	  }
	  
	  static int search(int in[], int start, int end, int val)
	  {
	    for (int i = start; i <= end; i++)
	      if (in[i] == val)
	        return i;
	    return end;
	  }
	
	static void print(Node root)
	{
		if(root != null)
		{
			System.out.print(root.key + " ");
			print(root.left);
			print(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of nodes: ");
		int n = s.nextInt();
		int in[] = new int[n];
		int post[] = new int[n];
		System.out.print("Enter the data of tree in inorder traversal: ");
		for(int i = 0; i < n; i++)
		{
			in[i] = s.nextInt();
		}
		
		System.out.print("Enter the data of tree in postorder traversal: ");
		for(int i = 0; i < n; i++)
		{
			post[i] = s.nextInt();
		}
		
		root = buildTree(in, post, n);
		print(root);
	}

}

