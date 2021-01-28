//Minimum spanning tree(Prim's Algorithm)

import java.util.*;
public class PrimsAlgo {
	
	static int V = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int graph[][] = { { 0, 4, 6, 0, 0, 0},  
                		  { 4, 0, 6, 3, 4, 0},  
                		  { 6, 6, 0, 1, 0, 0},  
                		  { 0, 3, 1, 0, 2, 3},  
                		  { 0, 4, 0, 2, 0, 7},
                		  { 0, 0, 0, 3, 7, 0} };   // adjacency matrix to represent graph
		
		solveMST(graph);
		
	}
	
	static void printMST(int parent[], int graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
    } 
	
	static void solveMST(int[][] graph)
	{
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		int[] parent = new int[V];
		parent[0] = -1;
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		
		for(int i = 0; i < V-1; i++)
		{
			int u = findMin(dist, visited);
			visited[u] = true;
			for(int j = 0; j < V; j++)
			{
				if(graph[u][j] != 0 && visited[j] == false && graph[u][j] < dist[j])
				{
					dist[j] = graph[u][j];
					parent[j] = u;
				}
			}
		}
		
		printMST(parent, graph);
		
		
		
	}
	
	static int findMin(int[] dist, boolean[] visited)
	{
		int min = Integer.MAX_VALUE;
		int vertex = -1;
		for(int i = 0; i < V; i++)
		{
			if(dist[i] < min && visited[i] == false)
			{
				min = dist[i];
				vertex = i;
			}
		}
		return vertex;
	}

}

