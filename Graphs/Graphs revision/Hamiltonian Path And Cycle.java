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

    int src = Integer.parseInt(br.readLine());

    HashSet<Integer> visited = new HashSet<>();
    dfs(graph, src, visited, src + "", src);

    // write all your codes here
  }

  static void dfs(ArrayList<Edge>[] graph, int src, HashSet<Integer> vis, String psf, int osrc)
  {
    if (vis.size() == graph.length - 1)
    {
      System.out.print(psf);
      boolean cycle = false;
      for (Edge e : graph[src])
      {
        if (e.nbr == osrc)
        {
          cycle = true;
        }
      }

      if (cycle == true)
        System.out.println("*");
      else
        System.out.println(".");
      return;
    }

    vis.add(src);

    for (Edge e : graph[src])
    {
      if (!vis.contains(e.nbr))
      {
        dfs(graph, e.nbr, vis, psf + e.nbr, osrc);
      }
    }
    vis.remove(src);
  }


}