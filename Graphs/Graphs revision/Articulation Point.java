
import java.util.*;
import java.io.*;

class Main {
    
    static boolean vis[];
    static int time;
    static int[] parent;
    static int[] disc;
    static int low[];
    static boolean ap[];

  public static void main(String[] args) {
      
      Scanner s = new Scanner(System.in);
      int V = s.nextInt();
      int E = s.nextInt();
      
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < V; i++)
        graph.add(new ArrayList<>());
    
      for(int i = 0; i < E; i++)
      {
          int u = s.nextInt()-1; // as graph is based on index 1 so we are converting it to zero based
          int v = s.nextInt()-1;
          graph.get(u).add(v);
          graph.get(v).add(u);
      }
      
      vis = new boolean[V];
      time = 0;
      parent = new int[V];
      disc = new int[V];
      low = new int[V];
      ap = new boolean[V];
      
      parent[0] = -1;
      dfs(0, graph);
      
      int res = 0;
      
      for(int i = 0; i < V; i++)
      {
        //   System.out.println(ap[i]);
         if(ap[i])
            res++;
      }
      
      System.out.println(res);
      

  }
  
  
  static void dfs(int src, ArrayList<ArrayList<Integer>> g)
  {
      disc[src] = low[src] = time;
      time++;
      vis[src] = true;
      int count = 0;
      
      ArrayList<Integer> l = g.get(src);
      
      for(int i = 0; i < l.size(); i++)
      {
          int v = l.get(i);
          
          if(parent[src] == v)
            continue;
          else if(vis[v])
            low[src] = Math.min(low[src], disc[v]);
          else
          {
              parent[v] = src;
              count++;
              dfs(v, g);
              low[src] = Math.min(low[src], low[v]);
              
              if(parent[src] == -1)
              {
                 if(count >= 2)
                 {
                     ap[src] = true;
                 }
              }
              else{
                  if(low[v] >= disc[src])
                  {
                      ap[src] = true;
                  }
              }
          }
      }
      
  }
  

}