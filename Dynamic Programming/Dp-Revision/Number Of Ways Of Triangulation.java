/*

Number Of Ways Of Triangulation

1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		// write your code here
		
	// Number Of Ways Of Triangulation in poygon = catalan(n-2)
		n = n-2;
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
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
