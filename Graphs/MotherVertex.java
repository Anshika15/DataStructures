import java.util.*;
public class MotherVertex {
	private int V;
	LinkedList<Integer> adj[];
	boolean visited[];
	int vertex;
	
	void graph(int v)
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
	
	void findMother()
	{
		for(int i = 0; i < V; i++)
		{
			if(visited[i] == false)
			{
				dfs(i);
				vertex = i; // last vertex whose traversal has been completed
			}
		}
		
		Arrays.fill(visited, false);
		
		
		dfs(vertex);  // check the dfs of the last traversed vertex
		
		
		for(int i = 0; i < V; i++)
		{
			if(visited[i] == false)  // if we are able to go through every vertex from the given vertex than it is a mother vertex
			{
				System.out.println("No mother vertex");
				return;
			}
		}
		System.out.println("Mother vertex is: " + vertex);
	}
	
	void dfs(int root)
	{
		 visited[root] = true;
		// System.out.print(root + " ");
		 Iterator<Integer> itr = adj[root].listIterator();
			
			while(itr.hasNext())
			{
				int n = itr.next(); 
	            if (!visited[n]) 
	            {
	                dfs(n); 
	            }
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MotherVertex m = new MotherVertex();
		
		m.graph(7);
		
		m.addEdge(0, 1);
		m.addEdge(0, 2);
		m.addEdge(1, 3);
		m.addEdge(4, 1);
		m.addEdge(6, 4);
		m.addEdge(5, 6);
		m.addEdge(5, 2); 
		m.addEdge(6, 0);
        
        m.findMother();
	

	}

}

