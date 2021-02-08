import java.util.*;

public class DetectCycleDirectedGraph {
	
	ArrayList<Integer> adj[];
	int V;
	int E;
	boolean vis[];
	public DetectCycleDirectedGraph(int v, int e) {
		
		V = v;
		E = e;
		adj = new ArrayList[V];
		vis = new boolean[V];
		Arrays.fill(vis,  false);
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
		
	}
	
	void add(int src, int dest)
	{
		adj[src].add(dest);
	}

	boolean isCyclic()
	{
		boolean flag = false;
		
		for(int i = 0; i < V; i++)
		{
			vis[i] = true;
			for(int j = 0; j < adj[i].size(); j++)
			{
				flag = isCyclicUtil(adj[i].get(j));
				if(flag == true)
				{
					return true;
				}	
			}
			vis[i] = false;
		}
		
		return false;
	}
	
	boolean isCyclicUtil(int curr)
	{
		if(vis[curr] == true)
			return true;
		vis[curr] = true;
		boolean flag = false;
		for(int i = 0; i < adj[curr].size(); i++)
		{
			flag = isCyclicUtil(adj[curr].get(i));
		    if(flag == true)
		    	return true;
		}
		vis[curr] = false;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		DetectCycleDirectedGraph graph = new DetectCycleDirectedGraph(5, 6);
		
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.add(src, dest);
		}
	/*	for(int i = 0; i < graph.V; i++)
			System.out.println(graph.adj[i]);*/
		
		System.out.println("graph contains cycle: " + graph.isCyclic());
		
		s.close();

	}

}

