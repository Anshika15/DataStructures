/*
 	Given a value N, find the number of ways to make change for N cents, 
 	if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.
 */

import java.util.*;
public class CoinChange1 {
	
	public static long count(int S[], int m, int n) 
    { 
        //code here.
        long t[][] = new long[m+1][n+1];
        for(int i = 0; i < m+1; i++)
        {
            for(int j = 0; j < n+1; j++)
            {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }
        
        for(int i = 1; i < m+1; i++)
        {
            for(int j = 1; j < n+1; j++)
            {
                if(S[i-1] <= j)
                {
                    t[i][j] = t[i-1][j] + t[i][j - S[i-1]];
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[m][n];
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[] = new int[m+1];
		for(int i = 0; i < m; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Total number of ways: " + count(arr, m, n));

	}

}

