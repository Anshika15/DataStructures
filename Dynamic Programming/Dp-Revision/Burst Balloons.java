/*

Burst Balloons

1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.

*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr) {
    //write your code here
    
    int[][] dp = new int[arr.length][arr.length];
    
    for(int g = 0; g < dp.length; g++)
    {
        for(int i = 0, j = g; j < dp.length; j++, i++)
        {
            int max = Integer.MIN_VALUE;
            for(int k = i; k <= j; k++)
            {
                int left = k == i ? 0 : dp[i][k-1];
                int right = k == j ? 0 : dp[k+1][j];
                
                int val = arr[k];
                if( i > 0)
                    val = arr[i-1]*val;
                if(j != arr.length-1)
                    val = arr[j+1]*val;
                
                int total = left+right+val;
                max = Math.max(total, max);
            }
            
            dp[i][j] = max;
        }
    }

    return dp[0][dp.length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
