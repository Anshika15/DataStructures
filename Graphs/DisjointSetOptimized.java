

import java.util.*;

class GraphsI{
    int V, E;    
    Edge edge[]; 
    NodeI[] list;
    class Edge
    {
        int src, dest;
    }
    
    class NodeI{
    	int parent;
    	int rank;
    }
    
    GraphsI(int v,int e)
    {
        V = v;
        E = e;
        list = new NodeI[V];
        for(int i = 0; i < V; i++)
        {
        	list[i] = new NodeI();
        	list[i].parent = -1;
        	list[i].rank = 0;
        }
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    
    boolean isCyclic()
    {
    	
    	for(int i = 0; i < E; i++)
    	{
    		int fromP = find(edge[i].src);
    		int ToP = find(edge[i].dest);
    		if(fromP == ToP)
    			return true;
    		union(fromP, ToP);
    	}
    	return false;
    }
    
    int find(int u)
    {
    	if(list[u].parent == -1)
    	{
    		return u;
    	}
    	return list[u].parent = find(list[u].parent);
    }
    
    void union(int u, int v)
    {
    	if(list[u].rank > list[v].rank)
    		list[v].parent = u;
    	else if(list[u].rank < list[v].rank)
    		list[u].parent = v;
    	else
    	{
    		list[u].parent = v;
    		list[v].rank += 1;
    	}
    }
}


public class DisjointSetOptimized {

	public static void main(String[] args) {
		
		GraphsI graph = new GraphsI(4,3);
		
	 	graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 3;
 
        graph.edge[2].src = 2;
        graph.edge[2].dest = 3;
   	 
      
        System.out.println("graph contains cycle: " + graph.isCyclic() );

	}

}

