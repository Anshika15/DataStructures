
/*

Longest Palindromic Subsequences

1. You are given a string str.
2. You are required to print the length of longest palindromic subsequence of string str.

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        String str = s.nextLine();
        
        int[][] dp = new int[str.length()][str.length()];
        
        for(int g = 0; g < dp.length; g++)
        {
            for(int i = 0, j = g; j < dp.length; j++, i++)
            {
                if(g == 0)
                {
                    dp[i][j] = 1;
                }
                else if(g == 1)
                {
                    if(str.charAt(i) == str.charAt(j))
                        dp[i][j] = 2;
                    else dp[i][j] = 1;
                }
                else
                {
                    if(str.charAt(i) == str.charAt(j))
                        dp[i][j] = 2 + dp[i+1][j-1];
                    else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        
        System.out.println(dp[0][dp.length-1]);

    }

}
