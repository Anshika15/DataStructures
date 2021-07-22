import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
      }

      // write your code here
      
      boolean vis[] = new boolean[vtces];
      
      Stack<Integer> stack = new Stack<>();
      
      for(int i = 0; i < vtces; i++)
      {
          if(!vis[i])
            dfs(graph, vis, i, stack);
      }
      
      while(stack.size() > 0)
      {
          System.out.println(stack.pop());
      }
   }
   
   /* topological sort */
   
   public static void dfs(ArrayList<Edge>[] graph, boolean vis[], int src, Stack<Integer> stack)
   {
       vis[src] = true;
       for(Edge e : graph[src])
       {
           if(!vis[e.nbr])
           {
               dfs(graph, vis, e.nbr, stack);
           }
       }
       stack.add(src);
   }

}