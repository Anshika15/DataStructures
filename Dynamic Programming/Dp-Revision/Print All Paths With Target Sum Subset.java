import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(String psf, int i, int j){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here
        
        boolean dp[][] = new boolean[n+1][tar+1];
        
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[0].length; j++)
            {
                if(i == 0 && j == 0)
                {
                    dp[i][j] = true;
                }
                else if(i == 0)
                {
                    dp[i][j] = false;
                }
                else if(j == 0)
                {
                    dp[i][j] = true;
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                    if( j >= arr[i-1])
                    {
                        dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                    }
                }
            }
        }
        
        System.out.println(dp[n][tar]);
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair("", n, tar));
        
        while(q.size() > 0)
        {
            Pair rem = q.removeFirst();
            if(rem.i == 0 || rem.j == 0)
            {
                System.out.println(rem.psf);
            }
            else{
                if(rem.j >= arr[rem.i-1])
                {
                    boolean inc = dp[rem.i-1][rem.j - arr[rem.i-1]];
                    if(inc)
                {
                        q.add(new Pair((rem.i-1) + " " + rem.psf, rem.i - 1, rem.j - arr[rem.i-1]));
                    }
                }
                
                boolean exc = dp[rem.i - 1][rem.j];
                if(exc)
                {
                    q.add(new Pair(rem.psf, rem.i-1, rem.j));
                }
                
            }
            
        }

    }
}


                        


                        
