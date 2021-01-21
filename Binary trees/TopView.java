import java.util.Scanner;

/* class Node {
  int data; // data used as key value
  Node leftChild;
  Node rightChild;
  public Node()  {
    data=0;  }
  public Node(int d)  {
    data=d;  }
 } Above class is declared for use. */
class Result {
  static void printTopView(NodeT root) {
    
    if(root != null)
    {
      printleftView(root);
      if(root.rightChild != null)
      	printrightView(root.rightChild);
    }

  }
  
  static void printleftView(NodeT root)
  {
    if(root != null)
    {
      printleftView(root.leftChild);
      System.out.print(root.data + " ");
    }
  }
  
  static void printrightView(NodeT root)
  {
    if(root != null)
    {
      System.out.print(root.data + " ");
      printrightView(root.rightChild);
    }
  }
}


class NodeT
{
  int data; // data used as key value
  NodeT leftChild;
  NodeT rightChild;
  public NodeT()
  {
    data=0;
  }
  public NodeT(int d)
  {
    data=d;
  }
}

class TopView
{
  static void inOrder(NodeT root)
  {
    if (root != null)
    {
      inOrder(root.leftChild);
      System.out.print(root.data + " ");
      inOrder(root.rightChild);
    }
  }
  static NodeT insertLevelOrder(int arr[], NodeT root, int i, int n)
  {
    if (i < n)
    {
      NodeT temp = new NodeT(arr[i]);
      root = temp;
      root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
      root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
    }
    return root;
  }

  static NodeT buildTree(int t[], int n)
  {
    NodeT node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }
  public static void main(String[] args)
  {
    int a[]=new int[50];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    NodeT root = null;
    if(n!=0)
      root = buildTree(a, n);
    Result.printTopView(root);
  }
}
