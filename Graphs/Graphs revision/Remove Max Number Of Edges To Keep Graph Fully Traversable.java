import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] edges = new int[m][3];
    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }
    Main obj = new Main();
    System.out.println(obj.maxNumEdgesToRemove(n, edges));
  }

  public int maxNumEdgesToRemove(int n, int[][] edges) {
      Arrays.sort(edges, (a,b) -> Integer.compare(b[0], a[0]));
      
      int ranka[] = new int[n+1];
      int rankb[] = new int[n+1];
      int parenta[] = new int[n+1];
      int parentb[] = new int[n+1];
      
      for(int i = 0; i < n+1; i++)
      {
          parenta[i] = i;
          ranka[i] = 1;
          parentb[i] = i;
          rankb[i] = 1;
      }
      
      int ca = 1;
      int cb = 1;
      int remove = 0;
      for(int[] e : edges)
      {
          if(e[0] == 3)
          {
            boolean tempa = union(e[1], e[2], parenta, ranka);  
            boolean tempb = union(e[1], e[2], parentb, rankb);  
            
            if(tempa == true)
            {
                ca++;
            }
            
            if(tempb == true)
            {
                cb++;
            }
            if(tempa == false && tempb == false)
            {
                remove++;
            }
          }
          else if(e[0] == 1)
          {
            boolean tempa = union(e[1], e[2], parenta, ranka);   
            if(tempa == true)
            {
                ca++;
            }
            else
            {
                remove++;
            }
          }
          else if(e[0] == 2)
          {
            boolean tempb = union(e[1], e[2], parentb, rankb);
            if(tempb == true)
            {
                cb++;
            }
            else
            {
                remove++;
            }
          }
      }
      
      if(ca != n || cb != n)
        return -1;
    return remove;

  }
  
  public int find(int x, int[] parent)
  {
      if(parent[x] == x)
        return x;
      parent[x] = find(parent[x], parent);
      return parent[x];
  }
  
  public boolean union(int x, int y, int[] parent, int[] rank)
  {
      int lx = find(x, parent);
      int ly = find(y, parent);
      
      if(lx != ly)
      {
          if(rank[lx] > rank[ly])
          {
             parent[ly] = lx; 
          }
          else if(rank[lx] < rank[ly])
          {
            parent[lx] = ly;  
          }
          else
          {
            parent[lx] = ly;  
            rank[ly]++;
          }
          return true;
      }
      return false;
  }


}
