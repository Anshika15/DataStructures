/*
1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn*/

import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords(int n){
        //write your code here
        
        if(n == 0 || n == 1)
            return 1;
        
       long dp[] = new long[n+1];
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
        System.out.println(NumberOfChords(n));
	}
}
