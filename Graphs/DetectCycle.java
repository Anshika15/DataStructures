import java.util.*;
public class DetectCycle {
	
	private int V;
	LinkedList<Integer> adj[];
	
	boolean visited[];
	
	DetectCycle(int v)
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
	
	
	boolean detect(int root, int parent)   // using dfs approach
	{
		visited[root] = true;
		
		Iterator<Integer> itr = adj[root].listIterator();
		while(itr.hasNext())
		{
			int n = itr.next();
			if(visited[n] == false)
			{
				if(detect(n, root) == true)
					return true;
			}
			else if(visited[n] == true)
			{
				if(n != parent)
					return true;
			}
			else
				return false;
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 DetectCycle g = new DetectCycle(4);
         g.addEdge(0, 1); 
	     g.addEdge(0, 2); 
	     g.addEdge(1, 2); 
	     g.addEdge(2, 0); 
	     g.addEdge(2, 3); 
	     g.addEdge(3, 3);
	     
	     boolean val = g.detect(0,-1);
	     
	     if(val == true)
	    	 System.out.println("graph contains cycle");
	     else
	    	 System.out.println("graph do not contains cycle");

	}

}

