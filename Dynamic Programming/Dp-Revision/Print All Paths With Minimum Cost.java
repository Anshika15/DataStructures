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
      int[][] dp = new int[arr.length][arr[0].length];
      
      
      for(int i = dp.length - 1; i >= 0; i--)
      {
          for(int j = dp[0].length - 1; j >= 0; j--)
          {
              if(i == dp.length - 1 && j == dp[0].length - 1)
              {
                dp[i][j] = arr[i][j];  
              }
              else if(i == dp.length - 1)
              {
                 dp[i][j] = dp[i][j+1] + arr[i][j]; 
              }
              else if(j == dp[0].length - 1)
              {
                dp[i][j] = dp[i+1][j] + arr[i][j];   
              }
              else
              {
                  int min = Math.min(dp[i+1][j], dp[i][j+1]);
                  dp[i][j] = min + arr[i][j];
              }
          }
      }
      
      System.out.println(dp[0][0]);
      
      LinkedList<Pair> q = new LinkedList<>();
      q.add(new Pair("", 0, 0));
      while(q.size() > 0)
      {
          Pair rem = q.removeFirst();
          if(rem.i == dp.length -1 && rem.j == dp[0].length - 1) // last element
          {
             System.out.println(rem.psf); 
          }
          else if(rem.i == dp.length -1) // last row
          {
             /* horizontal move */
             q.add(new Pair(rem.psf + "H", rem.i, rem.j+1));
          }
          else if(rem.j == dp[0].length -1) // last col
          {
             /* vertical move */
             q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j)); 
          }
          else
          {
              if(dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j])
              {
                  /* horizontal move */
                  q.add(new Pair(rem.psf + "H", rem.i, rem.j+1));
              }
              else if(dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j])
              {
                  /* vertical move */
                  q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
              }
              else // if both are equal
              {
                  /* vertical move */
                  q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                  
                  /* horizontal move */
                  q.add(new Pair(rem.psf + "H", rem.i, rem.j+1)); 
              }
          }
      }
   }

}
