import java.util.*;
public class ShortestPath {
	private int V;
	private LinkedList<Integer>[] adj;
	ShortestPath(int v)
	{
		V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	HashMap<Integer, Integer> level = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
	void path(int root, int v)
	{
        level.put(root, 0);
        parent.put(root, null);
		
		int i = 1;
		ArrayList<Integer> frontier = new ArrayList<Integer>();
		frontier.add(root);
		while(frontier.size() != 0)
		{
			ArrayList<Integer> next = new ArrayList<Integer>();
			for(int j = 0; j < frontier.size(); j++)
			{
				for(int k = 0; k < adj[frontier.get(j)].size(); k++)
				{
                    int h = adj[frontier.get(j)].get(k);
					if(!level.containsKey(h))
					{
					//	System.out.print(h + " ");  To print the bfs of root
						level.put(h, i);
						parent.put(h, frontier.get(j));
						next.add(h);
					}
				}
			}
			frontier = next;
			i++;
		}
		
		System.out.println("length of the path is: " + level.get(v));  // length of the path

	     int q = v;
	     ArrayList<Integer> arr = new ArrayList<Integer>();
	     arr.add(v);
	     while(parent.get(q) != null)
	     {
	    	 arr.add(parent.get(q));
	    	 q = parent.get(q);
	    	 
	     }
	     Collections.reverse(arr); 
	     System.out.println("path is: " + arr);  //path
	     
	}
	
	public static void main(String[] args) {
		ShortestPath g = new ShortestPath(8); // number of vertices will be passed to constructor
		g.addEdge(0, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 2); 
        g.addEdge(3, 4); 
        g.addEdge(3, 7); 
        g.addEdge(4, 5); 
        g.addEdge(4, 6); 
        g.addEdge(4, 7); 
        g.addEdge(5, 6); 
        g.addEdge(6, 7);
        
	    g.path(0,7);
	}

}

