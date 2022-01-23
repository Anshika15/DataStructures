/*

Wildcard Pattern Matching

1. You are given two strings S1 and S2. S1 represents a text and S2 represents a wildcard pattern.
2. You have to print 'true' if the wildcard pattern is matched with the given text, otherwise print 'false'.

The wildcard pattern can include the characters '?' and '*'
'?' - matches any single character
'*' - matches any sequence of characters (including the empty sequence)

*/

import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String str, String pattern) {
		boolean dp[][] = new boolean[pattern.length()+1][str.length()+1];
		
        
        for(int i = dp.length - 1; i >= 0; i--)
        {
            for(int j = dp[i].length - 1; j >= 0; j--)
            {
               if(i == dp.length - 1 && j == dp[0].length - 1)
                dp[i][j] = true;
               else if(i == dp.length - 1)
                dp[i][j] = false;
               else if(j == dp[0].length - 1){
                   if(pattern.charAt(i) == '*')
                    dp[i][j] = dp[i+1][j];
                   else
                    dp[i][j] = false;
               }
               else
               {
                   /* for question mark check whether next part is valid or not */
                   if(pattern.charAt(i) == '?')
                    dp[i][j] = dp[i+1][j+1];
                   /* for * we need to check with all chars after that in any case if it is true we can take it true (the ans for it would be by comparing all in next row but as we are already calculating the ans from that row for our previous ans we can check for current col and next row & curr row next col to calculate result for this it will help in reducing the time complexity from o(n^3) to o(n^2)) */
                   else if(pattern.charAt(i) == '*')
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                   else if(pattern.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                   else
                    dp[i][j] = false;
               }
            }
        }
        
        return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
