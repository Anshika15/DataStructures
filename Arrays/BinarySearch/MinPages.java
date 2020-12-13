/*
 * Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages.
 *  Every student is assigned to read some consecutive books.
 *  The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
 */

import java.util.*;
public class MinPages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = s.nextInt();
		}
		int m = s.nextInt();
		System.out.println("Max number of pages assigned to a student is : " + findPages(arr, n, m));
	}
	
	public static int findPages(int[]a,int n,int m)
	{
	    //Your code here
	    if(n < m)
	        return -1;
	    int res = -1;
	    int start = Arrays.stream(a).max().getAsInt(); ;
	    int end = 0;
	    for(int i = 0; i < n; i++)
	    {
	        end += a[i];
	    }
	    while(start <= end)
	    {
	        int mid = start + (end - start)/2;
	        if(isValid(a, n, m, mid) == true)
	        {
	            res = mid;
	            end = mid-1;
	        }
	        else
	            start = mid + 1;
	    }
	    return res;
	}

	public static boolean isValid(int[] arr, int n, int m, int max)
	{
	    int students = 1;
	    int sum = 0;
	    for(int i = 0; i < n; i++)
	    {
	        sum = sum+arr[i];
	        if(sum > max)
	        {
	            students++;
	            sum = arr[i];
	        }
	        if(students > m)
	            return false;
	    }
	    return true;
	}

}

