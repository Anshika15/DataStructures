import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      
      int dp[][] = new int[n][m];
      
      for(int j = arr[0].length - 1; j >= 0; j--)
      {
          for(int i = 0; i < arr.length; i++)
          {
              if(j == arr[0].length - 1)
              {
                  dp[i][j] = arr[i][j];
              }
              else if(i == 0)
              {
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);    
              }
              else if(i == dp.length - 1)
              {
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);  
              }
              else
              {
                dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1],dp[i-1][j+1]));   
              }
          }
      }
      
      int res = dp[0][0];
      for(int i = 0; i < dp.length; i++)
      {
          res = Math.max(res, dp[i][0]);
      }
      System.out.println(res);
      
      LinkedList<Pair> q = new LinkedList<>();
      
      for(int i = 0; i < arr.length; i++)
      {
          if(dp[i][0] == res)
          {
              q.add(new Pair(i + "", i, 0));
          }
      }
      
      while(q.size() > 0)
      {
          Pair rem = q.removeFirst();
          
          if(rem.j == arr[0].length - 1)
          {
             System.out.println(rem.psf);
          }
          else if(rem.i == 0)
          {
              int max = Math.max(dp[rem.i][rem.j+1], dp[rem.i+1][rem.j+1]); 
              if(dp[rem.i][rem.j+1] == max)
              {
                q.add(new Pair(rem.psf + " d2", rem.i, rem.j+1));  
              }
              if(dp[rem.i+1][rem.j+1] == max)
              {
                q.add(new Pair(rem.psf + " d3", rem.i+1, rem.j+1));  
              } 
          }
          else if(rem.i == dp.length - 1)
          {
              int max = Math.max(dp[rem.i][rem.j+1], dp[rem.i-1][rem.j+1]);
              
              if(dp[rem.i-1][rem.j+1]== max)
              {
                q.add(new Pair(rem.psf + " d1", rem.i-1, rem.j+1));   
              }
              if(dp[rem.i][rem.j+1] == max)
              {
                q.add(new Pair(rem.psf + " d2", rem.i, rem.j+1));     
              }
          }
          else
          {
              int max = Math.max(dp[rem.i][rem.j+1], Math.max(dp[rem.i+1][rem.j+1],dp[rem.i-1][rem.j+1]));  
              if(dp[rem.i-1][rem.j+1]== max)
              {
                q.add(new Pair(rem.psf + " d1", rem.i-1, rem.j+1));   
              }
              if(dp[rem.i][rem.j+1] == max)
              {
                q.add(new Pair(rem.psf + " d2", rem.i, rem.j+1));     
              }
              if(dp[rem.i+1][rem.j+1]== max)
              {
                q.add(new Pair(rem.psf + " d3", rem.i+1, rem.j+1));  
              } 
            
               
          }
          
      }
      
   }


}
