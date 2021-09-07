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
        
        int fee = s.nextInt();
        
        int buyShareProfit = -arr[0]; // first day we can buy and profit we are left with
        int sellShareProfit = 0; // first day we can't sell any share
        
        for(int i = 1; i < n; i++)
        {
            int newbuyShareProfit = 0;
            int newsellShareProfit = 0;
            
            /* for byuing*/
            if(sellShareProfit - arr[i] > buyShareProfit)  // buy new share from prev sell
            {
                newbuyShareProfit = sellShareProfit - arr[i];
            }
            else // keep the last buyed share with you
            {
               newbuyShareProfit = buyShareProfit;
            }
            
            
            /* for selling */
            if(buyShareProfit - fee + arr[i] > sellShareProfit) // sell the previous byued share 
            {
                newsellShareProfit = buyShareProfit - fee + arr[i];
            }
            else
            {
               newsellShareProfit = sellShareProfit; 
            }
            
            buyShareProfit = newbuyShareProfit;
            sellShareProfit = newsellShareProfit;
        }
        
        
        System.out.println(sellShareProfit);
        
    }

}
