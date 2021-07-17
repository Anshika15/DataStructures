import java.io.*;
import java.util.*;


public class Main {
  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      int u = Integer.parseInt(st[0]) - 1;
      int v = Integer.parseInt(st[1]) - 1;
      graph.get(u).add(v);
    }

    System.out.println(findMotherVertex(n, graph));
  }
  public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj) {

    boolean vis[] = new boolean[N];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++)
    {
      if (!vis[i])
      {
        dfs(adj, i, vis, stack);
      }
    }
    
    Arrays.fill(vis, false);
    dfs(adj, stack.peek(), vis);
    for(int i = 0; i < N; i++)
    {
        if(vis[i] == false)
            return -1;
    }
    return stack.pop()+1;
  }
  
  public static void dfs(ArrayList<ArrayList<Integer>>adj, int curr, boolean vis[], Stack<Integer> stack)
  {
      vis[curr] = true;
      for(int nbr : adj.get(curr))
      {
          if(!vis[nbr])
            dfs(adj, nbr, vis, stack);
      }
      stack.add(curr);
  }
  
  public static void dfs(ArrayList<ArrayList<Integer>>adj, int curr, boolean vis[]){
      
       vis[curr] = true;
      for(int nbr : adj.get(curr))
      {
          if(!vis[nbr])
            dfs(adj, nbr, vis);
      }
      
  }


}