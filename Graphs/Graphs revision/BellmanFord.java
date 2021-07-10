import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {

    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int m = s.nextInt();

    int[][] arr = new int[m][3];

    for (int i = 0;  i < m; i++)
    {
      arr[i][0] = s.nextInt() - 1;
      arr[i][1] = s.nextInt() - 1;
      arr[i][2] = s.nextInt();
      //   System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " ");
    }

    int path[] = new int[n];
    Arrays.fill(path, Integer.MAX_VALUE);

    path[0] = 0;

    for (int i = 0; i < n - 1; i++)
    {
      for (int j = 0; j < m; j++)
      {
        int u = arr[j][0];
        int v = arr[j][1];
        int wt = arr[j][2];
        if (path[u] == Integer.MAX_VALUE)
          continue;
        if (path[u] + wt < path[v])
          path[v] = path[u] + wt;
      }
    }

    for (int i = 1; i < n; i++)
    {
      if (path[i] != Integer.MAX_VALUE)
        System.out.print(path[i] + " ");
      else
        System.out.print("1000000000 ");
    }

    System.out.println();

  }
}
