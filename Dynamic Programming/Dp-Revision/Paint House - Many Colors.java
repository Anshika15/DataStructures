import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int k = s.nextInt();
        
        int arr[][] = new int[n][k];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < k; j++)
            {
                arr[i][j] = s.nextInt();
            }
        }

        int dp[][] = new int[n][k];
        
        // dp[n][k] min cost when we color the nth house with kth color
        
        
        /* O(n^3) solution */
    /*  for(int j = 0; j < k; j++)
        {
            dp[0][j] = arr[0][j];
        } 
        
        
        
        for(int i = 1; i < n; i++) // i house number
        {
            for(int j = 0; j < k; j++) // j is color number
            {
                int min = Integer.MAX_VALUE;
                
                for(int cost = 0; cost < k; cost++) // check the min in prev row
                {
                    if(cost != j)
                    {
                        min = Math.min(dp[i-1][cost], min);
                    }
                }
                
                dp[i][j] = min + arr[i][j];
            }
        }
        
        
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++){
            res = Math.min(res, dp[n-1][j]);
        }
        
        System.out.println(res);
        
    */
    
    
    /* O(n^2) solution */
    int least = Integer.MAX_VALUE;
    int secondLeast = Integer.MAX_VALUE;
    for(int j = 0; j < k; j++)
    {
        dp[0][j] = arr[0][j];
        if(arr[0][j] <= least)
        {
            secondLeast = least;
            least = arr[0][j];
        }
        else if(arr[0][j] <= secondLeast)
        {
            secondLeast = arr[0][j];
        }
    } 
        
    for(int i = 1; i < n; i++)
    {
        int nleast = Integer.MAX_VALUE;
        int nsecondLeast = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++)
        {
            if(least == dp[i-1][j])
            {
                dp[i][j] = secondLeast + arr[i][j];
            }
            else
            {
                dp[i][j] = least + arr[i][j];
            }
            
            if(dp[i][j] <= nleast)
            {
                nsecondLeast = nleast;
                nleast = dp[i][j];
            }
            else if(dp[i][j] <= nsecondLeast)
            {
                nsecondLeast = dp[i][j];
            }
        }
        
        secondLeast = nsecondLeast;
        least = nleast;
    }
        
        System.out.println(least);
    }
}
