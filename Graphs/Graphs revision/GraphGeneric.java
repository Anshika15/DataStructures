// Java program to implement Graph
// with the help of Generics

import java.util.*;

class GraphGen<T> {

	// We use Hashmap to store the edges in the graph
	private Map<T, List<T> > map = new HashMap<>();

	// This function adds a new vertex to the graph
	public void addVertex(T vertex)
	{
		map.put(vertex, new LinkedList<T>());
	}

	// This function adds the edge
	// between source to destination
	public void addEdge(T u, T v, boolean bidir)
	{

		if (!map.containsKey(u))
			addVertex(u);

		map.get(u).add(v);
		if (bidir == true) {
			if (!map.containsKey(v))
				addVertex(v);
			
			map.get(v).add(u);
		}
	}

	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			for (T w : map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}

		return (builder.toString());
	}
}
 
public class GraphGeneric {

	public static void main(String args[])
	{

		// Object of graph is created.
		GraphGen<String> g = new GraphGen<String>();

		g.addEdge("putin", "Trump", false);
		g.addEdge("putin", "Modi", false);
		g.addEdge("putin", "Pope", false);
		g.addEdge("Modi", "Trump", true);
		g.addEdge("Modi", "yogi", true);
		g.addEdge("yogi", "prabhu", false);
		g.addEdge("prabhu", "Modi", false);
		
		System.out.println("Graph:\n" + g.toString());
		
		GraphGen<Integer> gr = new GraphGen<>();
		gr.addEdge(1, 2, true);
		gr.addEdge(100, 2, true);
		gr.addEdge(100, 3, true);

		System.out.println("Graph:\n" + gr.toString());

		
	}
}

