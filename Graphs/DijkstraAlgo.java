import java.util.Arrays;

/*
 * Goal: Given a graph, find shortest path from a source to all other vertices
 * 
 * Dijkstra Algorithm:-
 * 
 * 1. Maintain a set of processed nodes.
 * 2. Assign all nodes with distance value = infinity except source node.
 * 3. repeat following(unless all vertices are included)
 * 	i. pick min value vertex which is not already processed.
 *  ii. include this selected node in processed set.
 *  iii. update all the adjacent node distances if new distance < old distance then update else skip
 * 
 */

public class DijkstraAlgo {
	
	void shortestPath(int[][] graph) {
	
	// first and second steps..
	int len = graph.length;
	int[] parent = new int[len];
	parent[0] = -1;
	
	boolean processed[] = new boolean[len];
	Arrays.fill(processed, false);
	
	int value[] = new int[len];
	Arrays.fill(value, Integer.MAX_VALUE);
	value[0] = 0;
	
	// third step..
	for(int i = 0; i < len-1; i++)
	{
		int u = selectMinVertex(processed, value); //3 (i)
		processed[u] = true; // 3 (ii)
		
		for(int j = 0; j < len; j++)
		{
			// if there is an edge from u to j && if j is not processed && edge wt is smaller then current edge wt.
			if(graph[u][j] != 0 && processed[j] == false && value[u] != Integer.MAX_VALUE && (value[u] + graph[u][j] < value[j]))
			{
				value[j] = value[u] + graph[u][j];
			}
		}
	}
	
	//print shortest path graph
	
	for(int i = 1; i < len; i++)
	{
		System.out.println(parent[i] + " -> " + i + " (" + value[i] + ") ");
	}
		
	}
	
	int selectMinVertex(boolean[] processed, int[] value)
	{
		int min = Integer.MAX_VALUE;
		int vertex = -1;
		for(int i = 0; i < processed.length; i++)
		{
			if(processed[i] == false && min > value[i])
			{
				min = value[i];
				vertex = i;
			}
		}
		return vertex;
	}

	public static void main(String[] args) {
		
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            						  { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            						  { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            						  { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            						  { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            						  { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            						  { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            						  { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            						  { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
            						  
         DijkstraAlgo spg = new DijkstraAlgo();
         
         spg.shortestPath(graph);
         

	}
	
}

