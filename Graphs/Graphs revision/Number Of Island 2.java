
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
      
      List<Integer> list = new ArrayList<>();
      
      int[][] dirs = {
          {1,0},{0,1},{-1,0},{0,-1}
      };
      
      int[] parent = new int[n*m];
      int rank[] = new int[n*m];
      Arrays.fill(parent, -1);
      int ans = 0;
      
      for(int i = 0; i < positions.length; i++)
      {
          int row = positions[i][0];
          int col = positions[i][1];
          
          int cellNum = row*n + col;
          
          if(parent[cellNum] != -1)
          {
              list.add(ans);
              continue;
          }
          
          parent[cellNum] = cellNum;
          rank[cellNum] = 1;
          ans++;
          
          for(int[] dir : dirs)
          {
              int rowdash = dir[0] + row;
              int coldash = dir[1] + col;
              int celldash = rowdash*n + coldash;
              if(rowdash < 0 || coldash < 0 || rowdash >= m || coldash >= n || parent[celldash] == -1)
                continue;
                
              int lx = find(cellNum, parent);
              int ly = find(celldash, parent);
              
              if(lx != ly)
              {
                  if(rank[lx] < rank[ly])
                  {
                      parent[lx] = ly;
                  }
                  else if(rank[lx] > rank[ly])
                  {
                      parent[ly] = lx;
                  }
                  else
                  {
                      parent[ly] = lx;
                      rank[lx]++;
                  }
                  ans--;
              }
              
          }
          list.add(ans);
          
      }
      
      return list;

  }
  
  public static int find(int x, int[] parent)
  {
      if(parent[x] == x)
        return x;
        
      int temp = find(parent[x], parent);
      parent[x] = temp;
      return temp;
  }
}