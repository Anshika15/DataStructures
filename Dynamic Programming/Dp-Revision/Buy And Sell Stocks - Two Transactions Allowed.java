/*

Buy And Sell Stocks - Two Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        
        int profitIfSoldToday = 0; // profit if sold today
        int leastSoFar = arr[0];
        int[] dp = new int[n]; // max profit if sold upto today
        
        for(int i = 1; i < n; i++)
        {
            leastSoFar = Math.min(leastSoFar, arr[i]);
            
            profitIfSoldToday = arr[i] - leastSoFar;
            dp[i] = Math.max(profitIfSoldToday, dp[i-1]);
        }
        
        int profitIfBoughtToday = 0; // profit if buy today
        int maxSoFar = arr[n-1];
        int[] dp1 = new int[n]; // max profit if buy after today
        
        for(int i = n-2; i >= 0; i--)
        {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            
            profitIfBoughtToday = maxSoFar - arr[i];
            dp1[i] = Math.max(profitIfBoughtToday, dp1[i+1]);
        }
        
        int max = 0;
        for(int i = 0; i < n; i++)
        {
          max = Math.max(max, dp[i] + dp1[i]);  
        }
        System.out.println(max);
    }

}
