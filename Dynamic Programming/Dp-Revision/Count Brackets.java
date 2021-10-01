/*
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner s = new Scanner(System.in);
    
    int n = s.nextInt();
    
    System.out.println(solution(n));
    
 }
 
 static int solution(int n)
 {
     if(n == 0 || n == 1)
        return 1;
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    
    for(int i = 2; i <= n; i++)
    {
        for(int j = 0; j < i; j++)
        {
            dp[i] += dp[j]*dp[i-j-1];
        }
    }
    
    return dp[n];
 }

}
