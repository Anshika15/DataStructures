import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] prices) {
    // write your code here
    
    if(prices.length== 0)
        return 0;
    if(prices.length == 1)
        return prices[0];
    
    int nprices[] = new int[prices.length+1];
    
    for(int i = 0; i < prices.length; i++)
    {
        nprices[i+1] = prices[i];
       // System.out.print(nprices[i+1] + "-");
    }

    int dp[] = new int[nprices.length];
    dp[0] = 0;
    dp[1] = nprices[1];
    
    for(int i = 2; i < dp.length; i++)
    {
        dp[i] = nprices[i];
        int left = 1;
        int right = i-1;
        while(left <= right)
        {
            dp[i] = Math.max(dp[left]+dp[right], dp[i]);
            left++;
            right--;
        }
    }

    return dp[dp.length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }

}
