/*
 *   Articulation Point(AP):- A node is AP if removing it the number of components in the graph increases.
 *   
 *   1. if node u is root nod eof dfs tree and has atleast two children(subgraph) then u is AP
 *   2. Node u is not the root node of dfs tree and it has a child v such that no vertex in subtrees rooted with v 
 *   	has a backedge to one of the ancestors(parent edge is not included) of u.
 */
import java.util.*;

public class ArticulationPoints {
	
	int V;
	int E;
	ArrayList<Integer> adj[];
	
	int low[];
	int disc[];
	int parent[];
	boolean Ap[];
	int time;
	
	
	public ArticulationPoints(int v, int e) {
		V = v;
		E = e;
		adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		
		low = new int[V];
		Arrays.fill(low, -1);
		disc = new int[V];
		Arrays.fill(disc, -1);
		parent = new int[V];
		Arrays.fill(parent, -1);
		Ap = new boolean[V];
		Arrays.fill(Ap, false);
		time = 0;
	}

	void articulationPoints()
	{
		for(int i = 0; i < V; i++)
			if(disc[i] == -1)
				dfs(i);
	}
	
	void dfs(int u)
	{
		low[u] = disc[u] = time;
		time += 1;
		int child = 0;
		for(int v : adj[u])
		{
			if(disc[v] == -1)
			{
				child += 1;
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(low[u], low[v]);
				
				if(parent[u] == -1 && child > 1) // u is root node
					Ap[u] = true;
				
				if(parent[u] != -1 && low[v] >= disc[u])  // atleast one component get separated
					Ap[u] = true;
			}
			
			else if(v != parent[u]) // ignore child to parent edge
				low[u] = Math.min(low[u], disc[v]);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArticulationPoints graph = new ArticulationPoints(7, 8);
		
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest); // undirected graph.
			graph.adj[dest].add(src);
		}
		
//		for(int i = 0; i < graph.V; i++)
//		{
//			System.out.println(graph.adj[i]);
//		}
		
		graph.articulationPoints();
		
		System.out.print("Articulation Points in the given graph are: ");
		for(int i = 0; i < graph.V; i++)
		{
			if(graph.Ap[i] == true)
				System.out.print(i + " ");
		}
		
		s.close();

	}

}

