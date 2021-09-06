/*

Partition Into Subsets

1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34

*/

import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here
        if(n == 0 || k > n || k == 0)
            return 0;
            
        long dp[][] = new long[k+1][n+1];
        
        for(int team = 1; team <= k; team++)
        {
            for(int people = 1; people <= n; people++)
            {
                if(team > people)
                {
                    dp[team][people] = 0;
                }
                else if(team == people)
                {
                    dp[team][people] = 1;
                }
                else
                {
                    dp[team][people] = dp[team-1][people-1] + team * dp[team][people-1];
                }
            }
        }
        
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
