import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {

    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int m = s.nextInt();

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++)
    {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++)
    {
      int u = s.nextInt() - 1;
      int v = s.nextInt() - 1;

      graph.get(u).add(v);

    }

    System.out.println(kosarajuAlgo(graph, n, m));

  }

  public static int kosarajuAlgo(ArrayList<ArrayList<Integer>> graph, int n, int m)
  {
    boolean vis[] = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++)
    {
      if (!vis[i])
      {
        dfs(graph, i, vis, stack);
      }
    }

    // System.out.println(stack);
    // System.out.println(graph);
    
    ArrayList<ArrayList<Integer>> newgraph = transpose(graph, n);

    // System.out.println(newgraph);
    
    int count = 0;

    Arrays.fill(vis, false);

    while (stack.size() > 0) {
        int i = stack.pop();
      if (!vis[i])
      {
        dfs(newgraph, i, vis);
        count++;
      }
    }

    return count;
  }

  public static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean vis[], Stack<Integer> stack)
  {
    vis[curr] = true;
    for (int nbr : graph.get(curr))
    {
      if (!vis[nbr])
      {
        dfs(graph, nbr, vis, stack);
      }
    }
    stack.add(curr);
  }

  public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> graph, int n)
  {
    ArrayList<ArrayList<Integer>> newgraph = new ArrayList<>();

    for (int i = 0; i < n; i++)
    {
      newgraph.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++)
    {
      for (int nbr : graph.get(i))
      {
        newgraph.get(nbr).add(i);
      }
    }

    return newgraph;
  }

  public static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean vis[])
  {
    vis[curr] = true;
    for (int nbr : graph.get(curr))
    {
      if (!vis[nbr])
      {
        dfs(graph, nbr, vis);
      }
    }
  }

}
