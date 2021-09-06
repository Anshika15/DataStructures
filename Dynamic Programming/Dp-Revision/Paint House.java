import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int arr[][] = new int[n][3];
        for(int i = 0; i < n; i++)
        {
            arr[i][0] = s.nextInt(); // red
            arr[i][1] = s.nextInt(); // blue
            arr[i][2] = s.nextInt(); // green
        }
        
        long[][] dp = new long[n][3];
        
        dp[0][0] = arr[0][0]; // 1st house with red
        dp[0][1] = arr[0][1]; // 1st house with blue
        dp[0][2] = arr[0][2]; // 1st house with green
        
        for(int i = 1; i < n; i++)
        {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            
        }
        
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));

    }
}
