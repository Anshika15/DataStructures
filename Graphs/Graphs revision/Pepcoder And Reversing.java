import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
      
      
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int m = s.nextInt();
      
      ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
      for(int i = 0; i < n; i++)
        graph.add(new ArrayList<>());
        
      for(int i = 0; i < m; i++)
      {
          int u = s.nextInt()-1;
          int v = s.nextInt()-1;
          
          graph.get(u).add(new Pair(v, 0));
          graph.get(v).add(new Pair(u, 1));
      }
      
      LinkedList<Pair> q = new LinkedList<>();
      boolean[] vis = new boolean[n];
      
      q.addLast(new Pair(0,0));
      
      while(q.size() > 0)
      {
          Pair rem = q.removeFirst();
          
          if(rem.vtx == n-1)
          {
              System.out.println(rem.wt);
              return;
          }
          
          vis[rem.vtx] = true;
          
          for(Pair nbrs: graph.get(rem.vtx))
          {
              if(vis[nbrs.vtx])
                continue;
              else
              {
                  if(nbrs.wt == 0)
                  {
                     q.addFirst(new Pair(nbrs.vtx, rem.wt)); 
                  }
                  else
                  {
                      q.addLast(new Pair(nbrs.vtx, rem.wt + 1)); 
                  }
              }
          }
          
      }
      
      System.out.println("-1");

  }
  
  static class Pair{
      int vtx;
      int wt;
      Pair(int vtx, int wt)
      {
          this.vtx = vtx;
          this.wt = wt;
      }
  }
}

