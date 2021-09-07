/*

Buy And Sell Stocks - Infinite Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int[] prices = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            prices[i] = s.nextInt();
        }
        
        int buy = 0;
        int sell = 0;
        int profit = 0;
        
        for(int i = 1; i < n; i++)
        {
            if(prices[i] >= prices[i-1])
            {
                sell++;
            }
            else
            {
                profit += prices[sell] - prices[buy];
                buy = sell = i;
            }
        }
        profit += prices[sell] - prices[buy];
        System.out.println(profit);
    }

}
