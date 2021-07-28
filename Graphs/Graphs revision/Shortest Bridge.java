import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static class Pair {
    int r;
    int c;
    Pair(int r, int c)
    {
      this.r = r;
      this.c = c;
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }

  public static int shortestBridge(int[][] A) {

    LinkedList<Pair> q = new LinkedList<>();

    boolean vis[][] = new boolean[A.length][A[0].length];

    boolean flag = false;

    for (int i = 0; i < A.length && !flag; i++)
    {
      for (int j = 0; j < A[i].length && !flag; j++)
      {
        if (A[i][j] == 1)
        {
          dfs(A, vis, i, j, q);
          flag = true;
        }
      }
    }

    int level = 0;
    while (q.size() > 0)
    {
      int size = q.size();
      while (size-- > 0)
      {
        Pair rem = q.removeFirst();
        for (int val = 0; val < 4; val++)
        {
          int rowdash = rem.r + dirs[val][0];
          int coldash = rem.c + dirs[val][1];
          if (rowdash < 0 || coldash < 0 || rowdash >= A.length || coldash >= A[0].length || vis[rowdash][coldash] == true)
            continue;

          if (A[rowdash][coldash] == 1)
          {
            return level;
          }

          q.addLast(new Pair(rowdash, coldash));
          vis[rowdash][coldash] = true;
        }
      }
      level++;
    }
    return -1;

  }

  static int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

  public static void dfs(int[][] A, boolean vis[][], int i, int j, LinkedList<Pair> q )
  {
    vis[i][j] = true;
    q.addLast(new Pair(i, j));
    for (int val = 0; val < 4; val++)
    {
      int rowdash = i + dirs[val][0];
      int coldash = j + dirs[val][1];
      if (rowdash < 0 || coldash < 0 || rowdash >= A.length || coldash >= A[0].length || vis[rowdash][coldash] == true || A[rowdash][coldash] == 0)
        continue;

      dfs(A, vis, rowdash, coldash, q);
    }
  }

}
