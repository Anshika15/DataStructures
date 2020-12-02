import java.util.*;

public class QuickSort {
	private static int i, j;
	static void sort(int[] arr, int l , int r)
	{
		 if (l >= r) {
	            return;
	        }
	        partition(arr, l, r);
	        sort(arr, l, i);
	        sort(arr, j, r);
		
	}
	
	private static void partition(int[] a, int low, int high) {
	      
	    	if (high - low <= 1) {
	            if (a[high] < a[low])
	            {
	            	int temp = a[high];
	            	a[high] = a[low];
	            	a[low] = temp;
	            }
	            i = low;
	            j = high;
	            return;
	        }
	     
	        int mid = low;
	        int pivot = a[high];
	        while (mid <= high) {
	            if (a[mid] < pivot)
	            {
	            	int temp = a[mid];
	            	a[mid] = a[low];
	            	a[low] = temp;
	            	low++;
	            	mid++;
	              
	            }
	            else if (a[mid] == pivot)
	                mid++;
	            else if (a[mid] > pivot)
	            {
	            	int temp = a[high];
	            	a[high] = a[mid];
	            	a[mid] = temp;
	            	high--;
	               
	            }
	        }
	     
	        // update i and j
	        i = low - 1;
	        j = mid; // or high+1
	    }
	    
   public static void main(String args[])
   {
	   Scanner s = new Scanner(System.in);
	   int n = s.nextInt();
	   int[] arr = new int[n];
	   for(int i = 0; i < n; i++)
		   arr[i] = s.nextInt();
	   sort(arr , 0 , n-1);
	   for(int i = 0; i < n; i++)
		   System.out.print(arr[i] + " ");
   }
   
}

