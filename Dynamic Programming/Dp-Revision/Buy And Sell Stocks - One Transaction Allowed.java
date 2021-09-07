/*

Buy And Sell Stocks - One Transaction Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int price[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            price[i] = s.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            min = Math.min(min, price[i]);
            int profit = price[i] - min; // profit if we sell on this day
            maxProfit = Math.max(profit, maxProfit);
        }
        
        System.out.println(maxProfit);
        
    }

}
