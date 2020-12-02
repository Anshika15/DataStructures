import java.util.*;
public class GraphDFS {
	private int V;
	LinkedList<Integer> adj[];
	
	
	boolean visited[];
	
	GraphDFS(int v)
	{
		V = v;
		adj = new LinkedList[V];
		visited = new boolean[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	void dfs_check(int root)
	{
		visited[root] = true;
		System.out.print(root + " ");
		
		Iterator<Integer> itr = adj[root].listIterator();
		
		while(itr.hasNext())
		{
			int n = itr.next(); 
            if (!visited[n]) 
                dfs_check(n); 
		}
	}
	
	void dfs(int root)
	{
		dfs_check(root);
		
		 for (int i=0; i<V; ++i) 
	            if (visited[i] == false) 
	                dfs_check(i); 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphDFS g = new GraphDFS(4);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
		
        g.dfs(2);

	}

}

