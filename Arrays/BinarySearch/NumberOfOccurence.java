/*
	Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
*/

import java.util.*;
public class NumberOfOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int j = 0; j < t; j++)
		{
			int n = s.nextInt();
			int x = s.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = s.nextInt();
			}
			
			Solution sol = new Solution();
			System.out.println(sol.count(arr, n, x));
		}

	}

}

class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        
        int last = lastOccurence(arr, n, x) ;
        int first = firstOccurence(arr, n, x);
        if (first == -1 && last == -1)
            return 0;
        return last - first + 1;
        
    }
    
    int firstOccurence(int[] arr, int n, int element)
	{
	    int start = 0;
	    int end = n-1;
	    int res = -1;
	    while(start <= end)
	    {
	        int mid = start + (end - start) / 2;
	        if(element == arr[mid])
	        {
	            res = mid;
	            end = mid - 1;
	        }
	        else if(element < arr[mid])
	        {
	            end = mid - 1;
	        }
	        else
	        {
	            start = mid + 1;
	        }
	    }
	    return res;
	}
	
	int lastOccurence(int[] arr, int n, int element)
	{
	    int start = 0;
	    int end = n-1;
	    int res = -1;
	   // int mid = start + (end - start) / 2;
	    while(start <= end)
	    {
	        int mid = start + (end - start) / 2;
	        if(element == arr[mid])
	        {
	            res = mid;
	            start = mid + 1;
	        }
	        else if(element < arr[mid])
	        {
	            end = mid - 1;
	        }
	        else
	        {
	            start = mid + 1;
	        }
	    }
	    return res;
	}
}
