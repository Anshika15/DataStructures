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
        for(int amount = 1;amount <= target; amount++)
        {
            for(int coin : coins)
            {
                if(coin <= amount){
                    int remainingAmount = amount - coin;
                    dp[amount] += dp[remainingAmount];
                }
            }
        }
    System.out.println(dp[target]);
    }
}
