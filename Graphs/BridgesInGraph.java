/*
 * A Bridge is an edge removing which increases the number of components.
 * 
 * Approach:- 1) remove the edge from graph.
 * 			  2) perform dfs and see if there is only 1 component 
 * 				i. if components == 1 then removed edge is not bridge
 * 				ii. else removed edge is bridge
 * 			  3) put back the edge in graph.
 */

import java.util.*;

public class BridgesInGraph {
	int V;
	int E;
	ArrayList<Integer> adj[];
	
	int low[];
	int disc[];
	int parent[];
	HashMap<Integer, Integer> map = new HashMap<>();
	int time;
	
	public BridgesInGraph(int v, int e) {
		
		V = v;
		E = e;
		adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
		
		low = new int[V];
		Arrays.fill(low, -1);
		disc = new int[V];
		Arrays.fill(disc, -1);
		parent = new int[V];
		Arrays.fill(parent, -1);
		time = 0;
		
	}
	
	void bridge()
	{
		for(int i = 0; i < V; i++)
		{
			if(disc[i] == -1)
				dfs(i);
		}
			
	}
	
	void dfs(int u)
	{
		low[u] = disc[u] = time;
		time += 1;
		for(int v : adj[u])
		{
			if(disc[v] == -1)
			{
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(low[u],  low[v]);
				
				if(low[v] > disc[u])
					map.put(u , v);
			}
			else if(v != parent[u])
				low[u] = Math.min(low[u],  disc[v]);
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		BridgesInGraph graph = new BridgesInGraph(7,8);
		
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest); // undirected graph.
			graph.adj[dest].add(src);
		}
		
		graph.bridge();
		
		System.out.println(graph.map);
		
		s.close();

	}

}

