/*

Buy And Sell Stocks - K Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        
        int k = s.nextInt();
        
        int[][] dp = new int[k+1][n];
        
        
        /* O(n^3) solution */
/*      for(int i = 1; i <= k; i++)// transactions
        {
            for(int j = 1; j < n; j++)//day
            {
               int max = dp[i][j-1];
               for(int l = 0; l < j; l++)
               {
                   max = Math.max(max, dp[i-1][l] + arr[j] - arr[l]);
               }
               dp[i][j] = max;
            }
        }
 */       
 
    /* O(n^2) solution */
    
        for(int i = 1; i <= k; i++)// transactions
        {
            int max = Integer.MIN_VALUE;
            for(int j = 1; j < n; j++)//day
            {
               max = Math.max(max, dp[i-1][j-1] - arr[j-1]);
               dp[i][j] = Math.max(max + arr[j], dp[i][j-1]);
            }
        }
        
        System.out.println(dp[k][n-1]);
    }

}
