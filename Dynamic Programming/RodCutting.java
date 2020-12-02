/*
 	Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 	Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 */

import java.util.*;
public class RodCutting {
	static int calcProfit(int[] val, int n) {
			int W = n; // Length of the rod
			
			int len[] = new int[n];
			for(int i = 0; i < n; i++)
				len[i] = i+1;
			
			int t[][] = new int[n+1][W+1];
			
			for(int i = 0; i <= n; i++)
			{
				for(int j = 0; j <= W; j++)
				{
					if(i == 0 || j == 0)
						t[i][j] = 0;
				}
			}
			
			for(int i = 1; i < n+1; i++)
			{
				for(int j = 1; j < W+1; j++)
				{
					if(len[i-1] <= j)
					{
						t[i][j] = Math.max(val[i-1] + t[i][j-len[i-1]], t[i-1][j]);
					}
					else
						t[i][j] = t[i-1][j];
				}
			}
			return t[n][W];
	}
			
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		System.out.println("Max Profit: " + calcProfit(arr, n));

	}

}

