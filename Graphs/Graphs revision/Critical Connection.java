
import java.util.*;
import java.io.*;

class Main {
    
    static int[] parent;
    static int time;
    static int disc[];
    static int[] low;
    static boolean vis[];

  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {

    List<List<Integer>> l = new ArrayList<>();
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    for(int i = 0; i < n; i++)
    {
        graph.add(new ArrayList<>());
    }
    
    for(int i = 0; i < Edges.size(); i++)
    {
        int u = Edges.get(i).get(0);
        int v = Edges.get(i).get(1);
        
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    
 //   System.out.println(graph);
    parent = new int[n];
    disc = new int[n];
    low = new int[n];
    vis = new boolean[n];
    time = 0;
    
    bridges(0, graph, l);
    
    return l;

  }
  
  static void bridges(int src, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> l)
  {
      disc[src] = low[src] = time;
      time++;
      vis[src] = true;
      
      for(int i = 0; i < graph.get(src).size(); i++)
      {
          int nbr = graph.get(src).get(i);
          if(parent[src] == nbr)
          {
              continue;
          }
          else if(vis[nbr] == true)
          {
              low[src] = Math.min(low[src], disc[nbr]);
          }
          else
          {
             parent[nbr] = src;
             bridges(nbr, graph, l); 
             low[src] = Math.min(low[src], low[nbr]);
             
             if(low[nbr] > disc[src])
             {
                 List<Integer> temp = new ArrayList<>();
                 temp.add(src);
                 temp.add(nbr);
                 l.add(temp);
             }
          }
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }

}
