import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        // System.out.println(climbStairs(n, new int[n+1]);
        
        System.out.println(climbStairsTabulation(n));
    }
    
    /* memoization */
    public static int climbStairs(int n, int[] dp)
    {
        if(n == 0)
        {
            return 1;
        }
        else if(n < 0)
        return 0;
        
        int f1 = climbStairs(n-1, dp);
        int f2 = climbStairs(n-2, dp);
        int f3 = climbStairs(n-3, dp);
        
        dp[n] = f1+f2+f3;
        return dp[n];
    }
    
    /* tabulation */
    public static int climbStairsTabulation(int n){
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++)
        {
            if(i == 1){
                dp[i] = dp[i-1];
            }
            else if(i == 2)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[n];
        
    }

}
