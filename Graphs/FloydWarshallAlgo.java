
/*
 *  Goal:- find all pair shortest paths.
 *  Floyd warshall Algorithm
 *  time complexity - O(v^3)
 *  space complexity - O(v^2)
 */

import java.util.*;

public class FloydWarshallAlgo {
	
	void floydwarshall(int[][] graph)
	{
		int V = graph.length;
		int dist[][] = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				dist[i][j] = graph[i][j];
		
		for(int k = 0; k < V; k++) // for all vertices
		{
			for(int i = 0; i < V; i++) // matrix
			{
				for(int j = 0; j < V; j++)
				{
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
						continue;
					else if(dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		for(int i = 0; i < V; i++) // -ve edge cycles
		{
			if(dist[i][i] < 0)
			{
				System.out.println("graph containes -ve edge cycle");
				return;
			}
		}
		
		for(int i = 0; i < V; i++)
		{
			for(int j = 0; j < V; j++)
			{
				System.out.println(i + " " + j + " distance is " + dist[i][j]);
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[][] graph = {{0, 3, Integer.MAX_VALUE, 5},
						 {2, 0, Integer.MAX_VALUE, 8},
						 {Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
						 {Integer.MAX_VALUE,Integer.MAX_VALUE, 2, 0}};
		
		FloydWarshallAlgo obj = new FloydWarshallAlgo();
		obj.floydwarshall(graph);

	}

}

