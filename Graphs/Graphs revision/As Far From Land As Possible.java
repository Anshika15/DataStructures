import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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

    System.out.println(maxDistance(arr));

  }
  
   static class Pair{
      int x;
      int y;
      Pair(int x, int y)
      {
          this.x = x;
          this.y = y;
      }
  }
  
  public static int maxDistance(int[][] grid) {
      
      int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

    LinkedList<Pair> q = new LinkedList<>();
    
    for(int i = 0 ; i < grid.length; i++)
    {
        for(int j = 0; j < grid[0].length; j++)
        {
            if(grid[i][j] == 1)
                q.add(new Pair(i,j));
        }
    }
    
    if(q.size() == 0 || q.size() == grid.length*grid[0].length)
    {
        return -1;
    }
    
    int level = -1;
    
    while(q.size() > 0)
    {
       int size = q.size();
       level++;
       while(size-- > 0)
       {
           
           Pair rem = q.removeFirst();
           
           for(int i = 0; i < dirs.length; i++)
           {
               int rowdash = rem.x + dirs[i][0];
               int coldash = rem.y + dirs[i][1];
               
               if(rowdash < 0 || rowdash >= grid.length || coldash < 0 || coldash >= grid[0].length || grid[rowdash][coldash] == 1)
               {
                   continue;
               }
               
               q.add(new Pair(rowdash, coldash));
               grid[rowdash][coldash] = 1;
           }
       }
       
    }
    return level;
  }
}
