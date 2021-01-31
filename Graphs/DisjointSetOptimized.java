

import java.util.*;

class Graphs{
    int V, E;    
    Edge edge[]; 
    ArrayList<NodeI> list;
    class Edge
    {
        int src, dest;
    }
    
    class NodeI{
    	int parent;
    	int rank;
    }
    
    Graphs(int v,int e)
    {
        V = v;
        E = e;
        list = new ArrayList<>();
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
    	if(list.get(u).parent == -1)
    	{
    		return u;
    	}
    	return list.get(u).parent = find(list.get(u).parent);
    }
    
    void union(int u, int v)
    {
    	if(list.get(u).rank > list.get(v).rank)
    		list.get(v).parent = u;
    	else if(list.get(u).rank < list.get(v).rank)
    		list.get(u).parent = v;
    	else
    	{
    		list.get(u).parent = v;
    		list.get(v).rank += 1;
    	}
    }
}


public class DisjointSetOptimized {

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

