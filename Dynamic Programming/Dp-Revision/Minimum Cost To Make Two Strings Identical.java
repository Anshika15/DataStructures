/*

Minimum Cost To Make Two Strings Identical

1. You are given two strings S1, S2, and two numbers x and y.
2. The cost of deleting a character from S1 is x and the cost of deleting a character from S2 is y.
3. You can delete characters from both the strings.
4. You have to find the minimum cost required to make the given two strings identical.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2, int c1, int c2) {
	    
	    // as the cost is constant so min cost to make stt identical is by removing chars other than lcs
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i = s1.length()-1; i >= 0; i--)
		{
		    for(int j = s2.length()-1; j >= 0; j--)
		    {
		        if(s1.charAt(i) == s2.charAt(j))
		        {
		            dp[i][j] = dp[i+1][j+1]+1;
		        }
		        else
		        {
		            dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
		        }
		    }
		}
		
		int lcs = dp[0][0];
		return (s1.length() - lcs)*c1 + (s2.length() - lcs) * c2;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
	}

}
