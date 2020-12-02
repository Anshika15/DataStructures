import java.util.*;
public class BuildHeap {
	
	void build_max_heap(int[] arr, int n)
	{
		for(int i = (n/2) - 1; i >= 0; i--)
		{
			heapify(arr, n, i);
		}
	}
	
	  void heapify(int arr[], int n, int root) 
	    { 
	        int max = root; 
	        int l = 2 * root + 1;   //left child
	        int r = 2 * root + 2;   //right child
	  
	        if (l < n && arr[l] > arr[max]) 
	            max = l; 
	   
	        if (r < n && arr[r] > arr[max]) 
	            max = r; 
	  
	        if (max != root) 
	        { 
	            int temp = arr[root]; 
	            arr[root] = arr[max]; 
	            arr[max] = temp; 
	  
	            heapify(arr, n, max); 
	        } 
	    } 
	  
	  void build_min_heap(int[] arr, int n)
	  {
		  for(int i = (n / 2) - 1; i >= 0; i--)
		  {
			  min_heapify(arr, n , i);
		  }
	  }
	 
	  void min_heapify(int[] arr, int n, int root)
	  {
		  int min = root;
		  int l = 2 * root + 1;
		  int r = 2 * root + 2;
		  
		  if(l < n && arr[root] > arr[l])
		  {
			  min = l;
		  }
		  
		  if(r < n && arr[root] > arr[r])
		  {
			  min = r;
		  }
		  
		  if(min != root)
		  {
			  int temp = arr[root];
			  arr[root] = arr[min];
			  arr[min] = temp;
			  
			  min_heapify(arr, n , min);
		  }
	  }
	  
	 void display(int[] arr, int n)
	 {
		 for(int i = 0; i < n; i++)
			{
				System.out.print(arr[i] + " ");
			} 
		 System.out.println();
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of heap: ");
		int n = s.nextInt();
		System.out.println("Enter the elements of heap: ");
		int arr[] = new int[n];
		int arr1[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
			arr1[i] = arr[i];
		}
		BuildHeap obj = new BuildHeap();
		obj.build_max_heap(arr, n);
		
		System.out.println("max heap in array representation: ");
		obj.display(arr, n);
		
		obj.build_min_heap(arr1, n);
		System.out.println("min heap in array representation: ");
		obj.display(arr1, n);

	}

}

