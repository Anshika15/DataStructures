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
        
        int[] dp = new int[n]; //dp[i] contains the max lcs ending at i
        
        dp[0] = 1;
        int res = 1;
        
        for(int i = 1; i < dp.length; i++)
        {
           int max = 0;
           for(int j = 0; j < i; j++)
           {
               if(arr[j] < arr[i])
               {
                   max = Math.max(dp[j], max);
               }
           }
           
           dp[i] = max+1;
           res = Math.max(res, dp[i]);
        }
        
         System.out.println(res);
        
    }

}
