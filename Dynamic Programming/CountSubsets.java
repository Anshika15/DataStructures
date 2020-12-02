/*
    Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 */

import java.util.*;

public class CountSubsets {
	static int count(int[] arr, int n, int sum)
	{
		int[][] t = new int[n+1][sum+1];
		
		for(int i = 0; i < n+1; i++)
		{
			for(int j = 0; j  < sum + 1; j++)
			{
				if(i == 0)
					t[i][j] = 0;
				if(j == 0)
					t[i][j] = 1;
			}
		}
		
		for(int i = 1; i < n+1; i++)
		{
			for(int j =1; j < sum+1; j++)
			{
				if(arr[i-1] <= j)
				{
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][sum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = s.nextInt();
		System.out.print("Enter Sum: ");
		int sum = s.nextInt();
		int[] arr = new int[n];
		System.out.print("Enter the values of Array: ");
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		
		System.out.println("Count of Subsets: " + count(arr, n , sum));

	}

}

