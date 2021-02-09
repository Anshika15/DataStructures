import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CycleDirectedDfs {
	int V;
	int E;
	ArrayList<Integer> adj[];
	boolean vis[];
	boolean onpath[];
	
	CycleDirectedDfs(int v, int e)
	{
		V = v;
		E = e;
		adj = new ArrayList[V];
		onpath = new boolean[V]; // recursion stack 
		Arrays.fill(onpath,  false);
		
		vis = new boolean[V];
		Arrays.fill(vis, false);
		
		
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
	}
	
	boolean isCyclic()
    {
        for(int i = 0; i < V; i++) // to check for all the vertices.
        {
            if(vis[i] != true)
                if(dfs(i))
                    return true;
        }
        return false;
        
    }
    
    boolean dfs(int src)
    {
        if(vis[src]) // as we have already checked for the src node that it doesn't contains a cycle.
            return false;
        onpath[src] = vis[src] = true;
        for(int i = 0 ;i < adj[src].size(); i++)
        {
            if(onpath[adj[src].get(i)] == true)
                return true;
            else
                if(dfs(adj[src].get(i)))
                    return true;
        }
        onpath[src] = false;
        return false;
    }
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		CycleDirectedDfs graph = new CycleDirectedDfs(2, 2);
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest);
		}
		
		System.out.println("Graph contains cycle: " + graph.isCyclic());

	}

}

