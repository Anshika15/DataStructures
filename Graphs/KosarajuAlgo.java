/*
 * Kosaraju Algorithm  to find SCC
 * 1. preform DFS traversal of graph, push node to stack before returning.
 * 2. find the transpose of graph by reversing the edge
 * 3. pop nodes one by one from stack and again perform dfs on modified graph
 * 		keep popping nodes each successful dfs gives one SCC
 */

import java.util.*;

public class KosarajuAlgo {
	
	int V;
	int E;
	ArrayList<Integer> adj[];
	Stack<Integer> stack = new Stack<>();
	boolean vis[];
	ArrayList<Integer> rev[];
	
	public KosarajuAlgo(int v, int e) {
		
		V = v;
		E = e;
		adj = new ArrayList[V];
		vis = new boolean[V];
		Arrays.fill(vis,  false);
		
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		
		
		rev = new ArrayList[V];
		for(int i = 0; i < V; i++)
			rev[i] = new ArrayList<>();
	}
	
	void kosarajuAlgo()
	{
		// first step
		for(int i = 0; i < V; i++) 
		{
			if(!vis[i])
				dfsI(i);
		}
		
		// second step
		reverse();
		Arrays.fill(vis,  false);
		
		// third step
		while(!stack.isEmpty())
		{
			int curr = stack.pop();
			if(vis[curr] == false)
			{
				System.out.print("SCC: ");
				dfsII(curr);
				System.out.println();
			}
				
		}
	}
	
	void dfsI(int u)
	{
		vis[u] = true;
		for(int v : adj[u])
		{
			if(!vis[v])
				dfsI(v);
		}
		stack.push(u);
	}
	
	void reverse()
	{
		for(int i = 0; i < V; i++)
		{
			for(int j: adj[i])
				rev[j].add(i);
				
		}
	}
	
	void dfsII(int u)
	{
		System.out.print(u + " ");
		vis[u] = true;
		for(int ele : rev[u])
			if(!vis[ele])
				dfsII(ele);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		KosarajuAlgo graph = new KosarajuAlgo(8, 10);
		
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest);
		}
		
		s.close();
		
		graph.kosarajuAlgo();

	}

}

