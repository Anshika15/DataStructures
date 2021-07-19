import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    // write your code here

    ArrayList<Integer>[] edge = new ArrayList[n];
    for (int i = 0; i < n; i++)
    {
      edge[i] = new ArrayList<Integer>();
    }

    //   Scanner s = new Scanner(System.in);

    for (int i = 0; i < k; i++)
    {
      String[] parts = br.readLine().split(" ");
      int u = Integer.parseInt(parts[0]);
      int v = Integer.parseInt(parts[1]);

      edge[u].add(v);
      edge[v].add(u);
    }

    // int comps = 0;
    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean vis[] = new boolean[n];
    for (int i = 0; i < n; i++)
    {
      if (!vis[i])
      {
        ArrayList<Integer> comp = new ArrayList<>();
        dfs(edge, i, vis, comp);
        comps.add(comp);
      }
    }

    int res = 0;
    for(int i = 0; i < comps.size(); i++)
    {
        for(int j = i+1; j < comps.size(); j++)
        {
            res += comps.get(i).size() * comps.get(j).size();
            
        }
    }
    System.out.println(res);

  }

  static void dfs(ArrayList<Integer>[] edge, int src, boolean vis[], ArrayList<Integer> comp)
  {
    vis[src] = true;
    comp.add(src);
    ArrayList<Integer> list = edge[src];
    for (int nbr : list)
    {
      if (!vis[nbr])
      {
        dfs(edge, nbr, vis, comp);
      }
    }
  }

}