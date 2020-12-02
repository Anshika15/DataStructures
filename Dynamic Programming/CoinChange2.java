/*
	Given a value V and array coins[] of size M, the task is to make the change for V cents, 
	given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins.
	 Find the minimum number of coins to make the change. If not possible to make change then output -1
 */

import java.util.*;
public class CoinChange2 {
	
	public static int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int t[][] = new int[M+1][V+1];
	    for(int i = 0; i < M+1; i++)
	    {
	        for(int j = 0; j < V+1; j++)
	        {
	            if(j == 0)
	                t[i][j] = 0;
	            if(i == 0)
	                t[i][j] = Integer.MAX_VALUE - 1;
	            
	        }
	    }
	    
	    for(int i = 1; i < V+1; i++)
	    {
	        if(i % coins[0] == 0)
	            t[1][i] = i / coins[0];
	        else
	            t[1][i] = Integer.MAX_VALUE - 1;
	    }
	    
	    for(int i = 2; i < M+1; i++)
	    {
	        for(int j = 1; j < V+1; j++)
	        {
	            if(coins[i-1] <= j)
	            {
	                t[i][j] = Math.min(t[i-1][j] , t[i][j - coins[i-1]] + 1);
	            }
	            else
	                t[i][j] = t[i-1][j];
	        }
	    }
	    if(t[M][V] >= Integer.MAX_VALUE - 1)
	        return -1;
	  
	    return t[M][V];
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int coins[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			coins[i] = s.nextInt();
		}
		int v = s.nextInt();
		System.out.println("Minimum coins required: " + minCoins(coins, n, v));
	}

}

