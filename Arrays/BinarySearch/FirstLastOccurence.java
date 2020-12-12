/*
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Note: If the number x is not found in the array just print '-1'.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class FirstLastOccurence {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int j = 0; j < t; j++)
		{
		    int size = s.nextInt();
		    int element = s.nextInt();
		    int arr[] = new int[size];
		    for(int i = 0; i < size; i++)
		    {
		        arr[i] = s.nextInt();
		    }
		    int first = firstOccurence(arr, size, element);
		    int last = lastOccurence(arr, size, element);
		    if(first == -1 && last == -1)
		        System.out.println(first);
		    else
		        System.out.println(first + " " + last);
		}
	}
	
	static int firstOccurence(int[] arr, int n, int element)
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
	
	static int lastOccurence(int[] arr, int n, int element)
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
