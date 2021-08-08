import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    
    int n = s.nextInt();
    System.out.println(fib(n, new int[n+1]));
 }
 
 public static int fib(int n, int[] dp)
 {
     if(n == 0 || n == 1)
    {
        dp[n] = n;
        return dp[n];
    }
    
    if(dp[n] != 0)
        return dp[n];
    
    int f1 = fib(n-1, dp);
    int f2 = fib(n-2, dp);
    dp[n] = f1 + f2;
    return dp[n];
 }

}
