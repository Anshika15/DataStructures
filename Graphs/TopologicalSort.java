/*
 * A directed graph with no cycle is DAG
 * Topological sort is possible only in DAG
 * Topological Sort:- It is a linear ordering of vertices such that for every directed edge uv (u->v), 
 * 					  vertex u comes before vertex v in the ordering.
 */


import java.util.*;
public class TopologicalSort {
	int V;
	int E;
	ArrayList<Integer> adj[];
	boolean vis[];
	Stack<Integer> stack;
	
	TopologicalSort(int v, int e)
	{
		V = v;
		E = e;
		adj = new ArrayList[V];
		
		vis = new boolean[V];
		Arrays.fill(vis, false);
		stack = new Stack<>();
		
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
	}
	
	void topologicalSort()
	{
		for(int i = 0; i < V; i++)
		{
			if(vis[i] == false)
				dfs(i);
		}
		
	}
	
	void dfs(int src)
	{
		vis[src] = true;
		for(int i = 0; i < adj[src].size(); i++){
			if(!vis[adj[src].get(i)])
			{
				dfs(adj[src].get(i));
			}
		}
		stack.push(src);
	}
	
	void print()
	{
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		TopologicalSort graph = new TopologicalSort(6, 6);
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest);
		}
		
		for(int i = 0; i < graph.V; i++)
			System.out.print(graph.adj[i]);
		s.close();
		
		graph.topologicalSort();
		graph.print();

	}

}

