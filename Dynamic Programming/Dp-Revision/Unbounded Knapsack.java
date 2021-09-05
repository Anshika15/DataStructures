import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    int[] val = new int[n];
    int wt[] = new int[n];

    for (int i = 0; i < n; i++)
    {
      val[i] = s.nextInt();
    }

    for (int i = 0; i < n; i++)
    {
      wt[i] = s.nextInt();
    }

    int capacity = s.nextInt();

    int dp[] = new int[capacity + 1];

    for (int cap = 1; cap < dp.length; cap++)
    {
      int max = 0;
      for (int i = 0; i < n; i++)
      {
        if (wt[i] <= cap)
        {
          int remBagCap = cap - wt[i];
          int remBagValue = dp[remBagCap];
          int totalBagVal = remBagValue + val[i];

          max = Math.max(max, totalBagVal);
        }
      }

      dp[cap] = max;
    }

    System.out.println(dp[capacity]);

  }
}
