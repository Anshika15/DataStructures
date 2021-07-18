
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static int orangesRotting(int[][] grid) {
      
      LinkedList<Pair> queue = new LinkedList<>();
      int fresh = 0;
      for(int i = 0; i < grid.length; i++)
      {
          for(int j = 0; j < grid[0].length; j++)
          {
              if(grid[i][j] == 2)
              {
                  queue.add(new Pair(i,j));
              }
              if(grid[i][j] == 1)
              {
                  fresh++;
              }
          }
      }
      
      if(fresh == 0)
        return 0;
        
      int level = -1;
      
      int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
      while(queue.size() > 0)
      {
          int size = queue.size();
          level++;
          while(size-- > 0)
          {
              Pair rem = queue.removeFirst();
              
              for(int i = 0 ; i < dirs.length; i++)
              {
                  int rowdash = rem.row + dirs[i][0];
                  int coldash = rem.col + dirs[i][1];
                  
                  if(rowdash >= 0 && rowdash < grid.length && coldash >= 0 && coldash < grid[0].length && grid[rowdash][coldash] == 1)
                  {
                      queue.add(new Pair(rowdash, coldash));
                      grid[rowdash][coldash] = 0;
                      fresh--;
                  }
              }
          }
          
      }
      
      if(fresh == 0)
        return level;
      return -1;

  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(orangesRotting(arr));

  }

  public static class Pair {
    int row;
    int col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }

  }


}