/*
 	Given a set of N items, each with a weight and a value, and a weight limit W. Find the maximum value of a collection containing any of 
 	the N items any number of times so that the total weight is less than or equal to W.
 */


import java.util.*;

public class UnboundedKnapsack {
	 static int knapSack(int N, int W, int val[], int wt[])
	    {
	        int t[][] = new int[N+1][W+1];
	        for(int i = 0; i <= N; i++)
	        {
	            for(int j = 0; j <= W; j++)
	            {
	                if(i == 0 || j == 0)
	                    t[i][j] = 0;
	            }
	            
	        }
	        
	        for(int i = 1; i <= N; i++)
	        {
	            for(int j = 1; j <= W; j++)
	            {
	                if(wt[i-1] <= j)
	                {
	                    t[i][j] = Math.max(t[i-1][j], val[i-1] + t[i][j - wt[i-1]]);
	                }
	                else
	                {
	                    t[i][j] = t[i-1][j];
	                }
	            }
	        }
	        return t[N][W];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int w = s.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		for(int i = 0; i < n; i++)
			val[i] = s.nextInt();
		for(int i = 0; i < n; i++)
			wt[i] = s.nextInt();
		
		System.out.println("Maximum val: " + knapSack(n, w, val, wt));

	}

}

