/*
	Partition problem is to determine whether a given set can be partitioned
	 into two subsets such that the sum of elements in both subsets is the same. 
 */

import java.util.*;
public class EqualPartition {
	
	static boolean partition(int[] arr, int n)
	{
		int sum = 0;
		for(int i = 0; i < n; i++)
			sum += arr[i];
		if(sum % 2 != 0)
		{
			return false;
		}
		else
		{
			return subset(arr, n, sum/2);
		}
	}
	
	static boolean subset(int[] arr, int n, int sum)
	{
		boolean t[][] = new boolean[n+1][sum+1];
		for(int i = 0; i < n+1; i++)
		{
			for(int j = 0; j < sum + 1; j++)
			{
				if(i == 0)
					t[i][j] = false;
				if(j == 0)
					t[i][j] = true;
			}
		}
		
		for(int i = 1; i < n+1; i++)
		{
			for(int j = 1; j < sum +1; j++)
			{
				if(arr[i-1] <= j)
				{
					t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
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
		int[] arr = new int[n];
		System.out.print("Enter the values of Array: ");
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		
		System.out.println("Equal Partition Exists: " + partition(arr, n));

	}

}

