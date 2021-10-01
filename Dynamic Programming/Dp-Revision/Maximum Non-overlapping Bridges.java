import java.io.*;
import java.util.*;

public class Main {

  static class Pair implements Comparable<Pair> {
    int north;
    int south;

    Pair(int north, int south)
    {
      this.north = north;
      this.south = south;
    }

    public int compareTo(Pair p)
    {
      if (p.north != this.north)
        return this.north - p.north;
      else
        return this.south - p.south;
    }

  }

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    Pair[] arr = new Pair[n];

    for (int i = 0; i < n; i++)
    {
      int nth = s.nextInt();
      int sth = s.nextInt();

      arr[i] = new Pair(nth, sth);
    }

    Arrays.sort(arr);

    int[] dp = new int[n];
    int res = 0;
    for (int i = 0; i < n; i++)
    {
      int max = 0;

      for (int j = 0; j < i; j++)
      {
        if (arr[i].south > arr[j].south)
        {
          max = Math.max(dp[j], max);
        }
      }

      dp[i] = max + 1;
      res = Math.max(res, dp[i]);
    }

    System.out.println(res);

  }

}
