import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] val = new int[n];
        int wt[] = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            val[i] = s.nextInt();
        }
        
        for(int i = 0; i < n; i++)
        {
            wt[i] = s.nextInt();
        }
        
        int capacity = s.nextInt();
        
        int dp[][] = new int[n+1][capacity+1];
        
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= capacity; j++)
            {
                if(j >= wt[i-1])  /* if current elemnt is included */
                {
                    int remCap = j - wt[i-1];
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][remCap] + val[i-1]);
                }
                else /* if current element is not included */
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        System.out.println(dp[n][capacity]);

    }
}
