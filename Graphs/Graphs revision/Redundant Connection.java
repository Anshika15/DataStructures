
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);

    int[][] pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    int[] ans = findRedundantConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }

  public static int[] findRedundantConnection(int[][] edges) {
      
      int[] parent = new int[edges.length + 1];
      int rank[] = new int[edges.length+1];
      Arrays.fill(rank, 1);
      
      for(int i = 1; i < parent.length; i++)
        parent[i] = i;
        
      for(int i = 0; i < edges.length; i++)
      {
          int v1 = edges[i][0];
          int v2 = edges[i][1];
          
          int lv1 = find(parent, v1);
          int lv2 = find(parent, v2);
          
          if(lv1 != lv2)
          {
              if(rank[lv1] > rank[lv2])
              {
                parent[lv2] = lv1;  
              }
              else if(rank[lv1] < rank[lv2])
              {
                parent[lv1] = lv2;  
              }
              else
              {
                parent[lv1] = lv2;
                rank[lv2]++;
              }
          }
          else
          {
              return edges[i];
          }
          
          
      }

    return new int[2];
  }

  private static int find(int[] parent, int x) {
      
      if(parent[x] == x)
      {
          return x;
      }
      
      parent[x] = find(parent, parent[x]);
      return parent[x];

  }
}
