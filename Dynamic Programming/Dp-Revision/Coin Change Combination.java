import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int coins[] = new int[n];
        
        for(int i = 0; i < n; i++)
            coins[i] = s.nextInt();
        
        int target = s.nextInt();
        
        int dp[] = new int[target+1];
        dp[0] = 1; // to pay zero I have one move.
        for(int i = 0; i < coins.length; i++) // first take coins loop for combinations
        {
            for(int j = coins[i]; j < dp.length; j++)
            {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[target]);
    }
}
