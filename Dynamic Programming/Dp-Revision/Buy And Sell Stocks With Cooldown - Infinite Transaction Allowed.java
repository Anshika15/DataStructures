/*

Buy And Sell Stocks With Cooldown - Infinite Transaction Allowed


1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
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
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        
        int buyShareProfit = -arr[0];
        int sellShareProfit = 0;
        int cooldownShareProfit = 0;
        
        for(int i = 1; i < n; i++)
        {
            int newbuyShareProfit = 0;
            int newsellShareProfit = 0;
            int newcooldownShareProfit = 0;
            if(cooldownShareProfit - arr[i] > buyShareProfit)
            {
               newbuyShareProfit = cooldownShareProfit - arr[i];
            }
            else
            {
               newbuyShareProfit = buyShareProfit; 
            }
            
            if(buyShareProfit + arr[i] > sellShareProfit)
            {
                newsellShareProfit = buyShareProfit + arr[i];
            }
            else
            {
                newsellShareProfit = sellShareProfit;
            }
            
            if(sellShareProfit > cooldownShareProfit){
                newcooldownShareProfit = sellShareProfit;
            }
            else
            {
                newcooldownShareProfit = cooldownShareProfit;
            }
            
            buyShareProfit = newbuyShareProfit;
            sellShareProfit = newsellShareProfit;
            cooldownShareProfit = newcooldownShareProfit;
            
        }
        
        System.out.println(sellShareProfit);
        
    }

}
