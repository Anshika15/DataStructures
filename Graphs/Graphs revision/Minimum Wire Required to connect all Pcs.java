import java.io.*;
import java.util.*;

/* Minimum Spanning Tree Prims Algo */
public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static class Pair implements Comparable<Pair>{
       int v;
       int av; // aquiring vertex
       int wt;
       
       Pair(int v, int av, int wt)
       {
           this.v = v;
           this.av = av;
           this.wt = wt;
       }
       
       public int compareTo(Pair pair){
           return this.wt - pair.wt;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(0, -1, 0));
      
      boolean vis[] = new boolean[vtces];
      
      /* remove, mark visited, work(print), add neigbours */
      
      while(pq.size() > 0)
      {
          Pair rem = pq.remove(); // remove
          
          if(vis[rem.v] == true) // if already visited don't add it again
            continue;
          
          vis[rem.v] = true;  // mark
          
          if(rem.av != -1) // print
          {
              System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
          }
          
          for(Edge e: graph[rem.v])
          {
              if(vis[e.nbr] == false)
              {
                  pq.add(new Pair(e.nbr, rem.v, e.wt));
              }
          }
      }
      
      
      
   }

}