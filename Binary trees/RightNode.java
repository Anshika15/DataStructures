
import java.util.*;

public class RightNode
{
	
	static class Node
	{
	  int data; // data used as key value
	  Node leftChild;
	  Node rightChild;
	  public Node()
	  {
	    data=0;
	  }
	  public Node(int d)
	  {
	    data=d;
	  }
	}
	
	  static ArrayList<Integer> list = new ArrayList<Integer>();
	  static int flag = 0;
	  static int res = -1;
	  static int height(Node root)
	  {
	    if(root == null)
	      return 0;
	    else
	    {
	      int l = height(root.leftChild);
	      int r = height(root.rightChild);
	      if(l > r)
	        return l+1;
	      else
	        return r+1;
	    } 
	  }
	  static int findRightSibling(Node root, int key) {
	    
	   // System.out.println(height(root));
	    for(int i = 1; i <= height(root); i++)
	    {
	      level(root, i);
	      list.add(-1);
	    }
	    int i = list.indexOf(key);
	    if(list.size() > 1)
	  	  return list.get(i + 1);
	    return -1;

	  } 
	  static void level(Node root, int level)
	  {
	    if(root != null)
	    {
	    if(level == 1)
	    {
	     // System.out.print(root.data + " ");
	      list.add(root.data);
	    }
	    else
	    {
	      level(root.leftChild, level - 1);
	      level(root.rightChild, level - 1);
	    }
	    }
	  }
	

  static void preOrder(Node root)
  {
    if (root != null)
    {
      System.out.print(root.data + " ");
      preOrder(root.leftChild);
      preOrder(root.rightChild);
    }
  }
  static Node insertLevelOrder(int arr[], Node root, int i, int n)
  {
    if (i < n)
    {
      Node temp = new Node(arr[i]);
      root = temp;
      root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
      root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
    }
    return root;
  }

  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }
  public static void main(String[] args)
  {
    int a[]=new int[50];
    int n, i;
    Scanner s = new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    i = s.nextInt();
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    System.out.println(findRightSibling(root, i));
  }
}
