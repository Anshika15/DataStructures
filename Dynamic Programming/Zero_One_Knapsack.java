import java.util.*;
import java.lang.Math;

public class Zero_One_Knapsack {
	
	static int knapsack(int W, int wt[], int val[] , int n)
	{
		int t[][] = new int[n+1][W+1];
		
		//Initialization (base case of recursive function is converted to the initialization in dp)
		for(int i = 0; i < n+1; i++)
		{
			for(int j = 0; j < W+1; j++)
			{
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i = 1; i < n+1; i++)
		{
			for(int j = 1; j < W+1; j++)
			{
				if(wt[i-1] <= j)
					t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[n][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = s.nextInt();
		System.out.print("Enter the Weight: ");
		int W = s.nextInt();
		int[] wt = new int[n];
		int val[] = new int[n];
		System.out.print("Enter the values of Weight Array: ");
		for(int i  = 0 ; i < n; i++)
			wt[i] = s.nextInt();
		System.out.print("Enter the values of value Array: ");
		for(int i  = 0 ; i < n; i++)
			val[i] = s.nextInt();
		
		System.out.println("Maximum value: " + knapsack(W, wt, val, n));

	}

}

