/*
 *  1. Initialize all distance values as Infinity except source.
 *  2. repeat v-1 times:-
 *  	if(d[u] + cost(uv) < d[v])
 *  		update d[v];
 *  	else
 *  		skip;
 *  3. relax all vertices once more. if we find any other shortest path then there is negative edge wt cycle.
 * 
 */
import java.util.*;


public class BellmanFord {
	int V;
	int E;
	Edge[] edge;
	
	class Edge{
		int src;
		int dest; int wt;
	}

	BellmanFord(int v, int e)
	{
		 V = v;
	     E = e;
	     edge = new Edge[E];
	     for (int i = 0; i < e; ++i)
	            edge[i] = new Edge();
	}
	
	void bellmanford() {
		for (int i = 0; i < E; i++)
			{
				System.out.print(edge[i].src + " ");
				System.out.print(edge[i].dest + " "); 
				System.out.println(edge[i].wt); 
			}
		int parent[] = new int[V];
		int val[] = new int[V];
		parent[0] = -1;
		int cost[] = new int[V];
		Arrays.fill(val,  Integer.MAX_VALUE); // step 1
		val[0] = 0;
		
		boolean updated = false;
		for(int i = 0; i < V-1; i++) // repeat v-1 times for all edges.
		{
			updated = false;
			for(int j = 0; j < E; j++)
			{
				int u = edge[j].src;
				int v = edge[j].dest;
				int wt = edge[j].wt;
				if(val[u] != Integer.MAX_VALUE && ((val[u] + wt) < val[v]))
				{
					val[v] = val[u] + wt;
					parent[v] = u;
					cost[v] = val[v];
					updated = true;
				}
			}
			if(updated == false)
				break;
		}
		
		for(int j = 0; j < E && updated == true; j++) // 3rd step
		{
			int u = edge[j].src;
			int v = edge[j].dest;
			int wt = edge[j].wt;
			if(val[u] != Integer.MAX_VALUE && ((val[u] + wt) < val[v]))
			{
				System.out.println("negative edge wt cycle");
				return;
			}
		}
		
		for(int i = 1; i < V; i++)
		{
			System.out.println("u -> v" + parent[i] + " -> " + i + "  Cost to reach " + parent[i] +"from source 0 = " + val[i]);
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		BellmanFord graph = new BellmanFord(5, 8);
		
		for (int i = 0; i < 8; i++)
		{
			graph.edge[i].src = s.nextInt();
			graph.edge[i].dest = s.nextInt();
			graph.edge[i].wt = s.nextInt();
		}
		
		s.close();
		graph.bellmanford();


	}

}

