import java.util.*;

public class KruskalsAlgo {
	
	 class NodeII {
	    	int parent;
	    	int rank;
	    }
	
	class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int wt;
		
		public int compareTo(Edge compareEdge)
		{
			return this.wt - compareEdge.wt;
		}
		
	}
	
	 int V, E; 
	 Edge edge[];
	 Edge mst[];
	 NodeII[] list;
	 KruskalsAlgo(int v, int e)
	 {
	        V = v;
	        E = e;
	        edge = new Edge[E];
	        for (int i = 0; i < e; ++i)
	            edge[i] = new Edge();
	        
	        mst = new Edge[V-1];
	        for(int i = 0; i < V-1; i++)
	        	mst[i] = new Edge();
	        
	        list = new NodeII[V];
	        for(int i = 0; i < V; i++)
	        {
	        	list[i] = new NodeII();
	        	list[i].parent = -1;
	        	list[i].rank = 0;
	        }
	  }
	 
	 void MST()
	 {
		 Arrays.sort(edge);
		 
		 
		 int i = 0;
		 int j = 0;
		 while(i < V-1 && j < E)
		 {
			 int fromP = find(edge[j].src);
			 int toP = find(edge[j].dest);
			 if(fromP == toP)
			 {
				 ++j;
				 continue;
			 }
			 union(fromP, toP);
			 mst[i].src = edge[j].src;
			 mst[i].dest = edge[j].dest;
			 mst[i].wt = edge[j].wt;
			 ++i;
		 }
		 printMst();
	 }
	 
	 void printMst()
	 {
		 int cost = 0;
		 for(Edge i : mst)
		 {
			 System.out.println(i.src + " " + i.dest + " " + i.wt);
			 cost += i.wt;
		 }
		 
		 System.out.println("Min Cost: " + cost);
	 }
	 
	 
	 int find(int v)
	 {
		 if(list[v].parent == -1)
			 return v;
		 list[v].parent = find(list[v].parent);
		 return list[v].parent;
	 }
	
	 void union(int src, int dest)
	 {
		 if(list[src].rank > list[dest].rank)
			 list[dest].parent = src;
		 else if(list[src].rank < list[dest].rank)
			 list[src].parent = dest;
		 else
		 {
			 list[src].parent = dest;
			 list[dest].rank += 1;
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		KruskalsAlgo graph = new KruskalsAlgo(6, 10);
		for(int i = 0; i < 10; i++)
		{
			graph.edge[i].src = s.nextInt();
			graph.edge[i].dest = s.nextInt();
			graph.edge[i].wt = s.nextInt();
		}
		
		graph.MST();
		s.close();


	}

}

