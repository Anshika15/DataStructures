class LinkedListImplementation{
 Node head;  // first element of the list is in head
 static class Node{  // Node class is created
	int data;
	Node next;
	Node(int d)
	{
	  data = d;
	  next = null;
	}
   }

  public Node Create(int d)
   {
	return new Node(d);
   }


  public void insertAtBeg(int d) //Insert at beginning
   {

	if(head == null)
	  head = Create(d);
	else
	{
	 Node n = Create(d);
	 n.next = head;
	 head = n;
	}
	
   }


  public void insertAtEnd(int d)  //Insert At end
	{

	  if(head == null)
	  {
	    head = Create(d); // first node is created.
	  }
	  else
	   {
	     Node Last = head;
	     while(Last.next != null)	
	      {
	    	 Last = Last.next;
	    	 }
	     Last.next = Create(d);
	   }
	}
 
  public void insertAtPos(int index, int data)  //Insert at position
   	{
	if(index == 0)
	{
	  insertAtBeg(data);
	  return;
	}
	 Node n = Create(data);
	 int count = 0;
	  Node temp = head;
	  while(temp != null)
	{
	  count++;
	  if(count == index)
	  {
	    Node temp1 = temp.next;
	    temp.next = n;
	    n.next = temp1;
	  }
	 temp = temp.next;
	}
	}

 public void DelBeg() //Delete from beginning
  {
	head = head.next;
  }


 public void DelEnd()  // Delete at End
  {
	Node temp = head;
	while(temp != null)
	{
	  if(temp.next.next == null)
	   {
    	     temp.next = null;
	     return;
	   }	
	  temp = temp.next;
	}
  }

 public void DelPos(int i)  // Delete at a position
  {
	if(i == 0)
	{
	  DelBeg();
	  return;
	}
	Node temp = head;
	int c = 0;
	while(temp != null)
	{
	 c++;
	  if(c == i)
	   {
    	     temp.next = temp.next.next;
	     return;
	   }	
	  temp = temp.next;
	}
  }

  public void print()  // to print the linkedlist
   {
	Node temp = head;
	while(temp != null)
	{
	  System.out.print(temp.data + " ");
	  temp = temp.next;
	}
	System.out.println();
   }

 public static void main(String[] args)
  {
        LinkedListImplementation l = new LinkedListImplementation();
        l.insertAtBeg(10);	
        l.insertAtBeg(20);
        l.insertAtBeg(30);
        l.insertAtBeg(40);
        l.insertAtPos(0,2);
    
        
        l.print();
  }
}
