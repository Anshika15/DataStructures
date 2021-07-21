import java.io.*;
import java.util.*;

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

  static class Pair {
    int v;
    int level;
    Pair(int v, int level)
    {
      this.v = v;
      this.level = level;
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

    int vis[] = new int[vtces];
    Arrays.fill(vis, -1);
    for (int i = 0; i < vtces; i++)
    {
      if (vis[i] == -1)
      {
        boolean isBipartite = checkBipartite(graph, i, vis);
        if (isBipartite == false)
        {
          System.out.println(false);
          return;
        }
      }
    }

    System.out.println(true);
  }

  static boolean checkBipartite(ArrayList<Edge>[] graph, int src, int vis[])
  {
    LinkedList<Pair> q = new LinkedList<>();

    q.add(new Pair(src, 0));

    while (q.size() > 0)
    {

      /* remove, mark*, work, add* */
      Pair p = q.removeFirst();
      if (vis[p.v] != -1)
      {
        if(p.level != vis[p.v])
        {
            return false;
        }
      }

      else
      {
        vis[p.v] = p.level;
      }

      for(Edge e: graph[p.v])
      {
          if(vis[e.nbr] == -1)
          {
              q.add(new Pair(e.nbr, p.level+1));
          }
      }
    }
    return true;
  }
}