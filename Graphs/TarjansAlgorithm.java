/*
 *  Tarjans Algorithm for strongly connected components
 *  time complexity O(V+E);
 *  low = node with lowest disc time acessible
 *  disc = disc time of a node
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TarjansAlgorithm {
	int V;
	int E;
	ArrayList<Integer> adj[];
	boolean instack[];
	Stack<Integer> stack;
	int disc[];
	int low[];
	int time;
	
	public TarjansAlgorithm(int v, int e) 
	{
		V = v;
		E = e;
		adj = new ArrayList[V];
		time = 0;
		instack = new boolean[V];
		Arrays.fill(instack, false);
		time = 0;
		stack = new Stack<Integer>();
		disc = new int[V];
		low = new int[V];
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
		
	}
	
	void tarjansAlgo()
	{
		for(int i = 0; i < V; i++)
		{
			if(disc[i] == -1)
				 dfs(i);
		}
	}
	
	void dfs(int src)
	{
		disc[src] = low[src] = time;
		time += 1;
	//	System.out.println("time" + time);
		stack.push(src);
		instack[src] = true;
		for(int i : adj[src])
		{
			if(disc[i] == -1)
			{
				dfs(i);
				low[src] = Math.min(low[src],  low[i]);
			}
			// backEdge
			else if(instack[i] == true)
				low[src] = Math.min(low[src],  disc[i]);
		}
	//	System.out.println("stack" +  stack);
		
		// check the head node of strongly connected component
		if(low[src] == disc[src])
		{
			System.out.print("SCC:- ");
			int num = stack.peek();
			while(num != src)
			{
				System.out.print(stack.peek() + " ");
				instack[stack.peek()] = false;
				stack.pop();
				num = stack.peek();
			}
			System.out.println(stack.peek());
			instack[stack.peek()] = false;
			stack.pop();
		}
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		TarjansAlgorithm graph = new TarjansAlgorithm(7, 8);
		
		for(int i = 0; i < graph.E; i++)
		{
			int src = s.nextInt();
			int dest = s.nextInt();
			graph.adj[src].add(dest);
		}

		graph.tarjansAlgo();
	}

}

