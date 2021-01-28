
// Detect cycle in undirected graph using Disjoint set.

import java.util.*;

class Graphs{
    int V, E;    
    Edge edge[]; 
 
    class Edge
    {
        int src, dest;
    };
    int[] parent;
    Graphs(int v,int e)
    {
        V = v;
        E = e;
        parent = new int[V];
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
	
	
	boolean isCyclic()
	{
		Arrays.fill(parent, -1);
		for(int i = 0; i < E; i++)
		{
			int absParentsrc = find(edge[i].src);
			int absParentdest = find(edge[i].dest);
			if(absParentsrc == absParentdest)
				return true;
			union(absParentsrc, absParentdest);
		}
		return false;
	}
	
	int find(int v)
	{
		if(parent[v] == -1)
			return v;
		return find(parent[v]);
	}
	
	void union(int src, int dest)
	{
		int x = find(src);
		int y = find(dest);
		parent[x] = y;
	}
}

public class DisjointSetDetectCycle {

	public static void main(String[] args) {

		Graphs graph = new Graphs(4,4);
		
		graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	 
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 3;
	 
	        graph.edge[2].src = 2;
	        graph.edge[2].dest = 3;
	   	 
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 2;
		System.out.println("graph contains cycle: " + graph.isCyclic() );
		

	}

}

