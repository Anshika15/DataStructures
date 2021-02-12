import java.util.*;

public class KahnsAlgorithm {
	int V;
	int E;
	ArrayList<Integer> adj[];
	ArrayList<Integer> list = new ArrayList<>();
	int indegree[];
	public KahnsAlgorithm(int v, int e) {
		V = v;
		E = e;
		adj = new ArrayList[V];
		indegree = new int[V];
		Arrays.fill(indegree, 0);
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
	}
	
	boolean topological()
	{
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < V; i++)
			if(indegree[i] == 0)
				q.add(i);
		int count = 0;
		while(!q.isEmpty())
		{
			int curr = q.poll();
			for(int a : adj[curr])
			{
				indegree[a] -= 1;
				if(indegree[a] == 0)
					q.add(a);
			}
			list.add(curr);
			count += 1;
		}
		if(count != V)
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		KahnsAlgorithm graph = new KahnsAlgorithm(6, 6);
		
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest);
			graph.indegree[dest]++;
		}
		
		if(graph.topological())
			System.out.println(graph.list);
		else
			System.out.println("Gaph is not a DAG");
		s.close();
		
	}

}

