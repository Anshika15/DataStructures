/*
 	Given an integer array arr of size N, the task is to divide it into two sets S1 and S2
 	 such that the absolute difference between their sums is minimum and find the minimum difference
 */
import java.util.*;

public class MinDifference
{
	public static int minDiffernce(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i = 0; i < n; i++)
	        sum += arr[i];
	    boolean sol[][] = new boolean[n+1][sum+1];
	    for(int i = 0; i < n+1; i++)
	    {
	        for(int j = 0; j < n; j++)
	        {
	            if(i == 0)
	            {
	                sol[i][j] = false;
	            }
	            if(j == 0)
	            {
	                sol[i][j] = true;
	            }
	        }
	    }
	    
	    for(int i = 1; i < n+1; i++)
	    {
	        for(int j = 1; j < sum+1; j++)
	        {
	            if(arr[i-1] <= j)
	            {
	                sol[i][j] = sol[i-1][j-arr[i-1]] || sol[i-1][j];
	            }
	            else
	                sol[i][j] = sol[i-1][j];
	        }
	    }
	    LinkedList<Integer> list = new LinkedList<Integer>();
	    for(int i = 0; i <= sum / 2; i++)
	    {
	        if(sol[n][i] == true)
	        {
	            list.add(i);
	        }
	    }
	    int minval = Integer.MAX_VALUE;
	    for(int i = 0; i < list.size(); i++)
	    {
	        minval = Math.min(minval, sum - 2 * list.get(i));
	    }
	    return minval;
	} 
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i =0 ; i < n; i++)
			arr[i] = s.nextInt();
		System.out.println("Minimum difference: " + minDiffernce(arr, n));
	}
}

