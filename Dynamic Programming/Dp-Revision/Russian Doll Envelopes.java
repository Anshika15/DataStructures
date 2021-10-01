/*
1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed.

*/
import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair implements Comparable<Pair>{
        int ht;
        int wdth;
        
        Pair(int ht, int wdth)
        {
            this.ht = ht;
            this.wdth = wdth;
        }
        
        public int compareTo(Pair p)
        {
          return this.wdth - p.wdth;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        Pair[] arr = new Pair[n];
        
        for(int i = 0; i < n; i++)
        {
            int ht = s.nextInt();
            int wdth = s.nextInt();
            
            arr[i] = new Pair(ht, wdth);
        }
        
        Arrays.sort(arr);
        
        int dp[] = new int[n];
        int res = 0;
        
        for(int i = 0; i < n; i++)
        {
            int max = 0;
            for(int j = 0; j < i; j++)
            {
                // ht and wdth both should be less than the prev to get nested inside each other.
                if(arr[j].ht < arr[i].ht && arr[j].wdth < arr[i].wdth)
                    max = Math.max(dp[j],max);
            }
            
            dp[i] = max+1;
            res = Math.max(res, dp[i]);
        }
        
        System.out.println(res);
    }

}
