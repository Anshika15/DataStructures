import java.util.*;

public class Graph_BFS {
	int V;
	LinkedList<Integer> adj[];
	Graph_BFS(int v)
	{
		V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < v; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	
	void bfs(int s)
	{
	
		
		 boolean visited[] = new boolean[V]; 
		  
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 

	        visited[s]=true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	            s = queue.poll(); 
	            System.out.print(s+" "); 
	  
	            Iterator<Integer> itr = adj[s].listIterator(); 
	            while (itr.hasNext()) 
	            { 
	                int n = itr.next(); 
	                if (!visited[n]) 
	                { 
	                    visited[n] = true; 
	                    queue.add(n); 
	                } 
	            } 
	        } 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph_BFS g = new Graph_BFS(4);
		 g.addEdge(0, 1); 
	     g.addEdge(0, 2); 
	     g.addEdge(1, 2); 
	     g.addEdge(2, 0); 
	     g.addEdge(2, 3); 
	     g.addEdge(3, 3);
        
		g.bfs(2);
	}

}

