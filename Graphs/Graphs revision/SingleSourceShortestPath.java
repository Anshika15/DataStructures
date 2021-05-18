
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class GraphGenII<T> {

	// We use Hashmap to store the edges in the graph
	private Map<T, List<T>> map = new HashMap<>();

	// dist map for sssp(single source shortest path
	Map<T, Integer> dist = new HashMap<>();

	// This function adds a new vertex to the graph
	public void addVertex(T vertex) {
		map.put(vertex, new LinkedList<T>());
		dist.put(vertex, Integer.MAX_VALUE); // initialize the distance map with infinity
	}

	// This function adds the edge
	// between source to destination
	public void addEdge(T u, T v, boolean bidir) {

		if (!map.containsKey(u)) {
			addVertex(u);
			dist.put(u, Integer.MAX_VALUE);
		}

		map.get(u).add(v);
		if (bidir == true) {
			if (!map.containsKey(v)) {
				addVertex(v);
				dist.put(v, Integer.MAX_VALUE);
			}

			map.get(v).add(u);
		}
	}

	

	void bfs(T src) {
		Queue<T> q = new LinkedList<>();

		// Map<T, Boolean> visited = new HashMap<>();
		q.add(src);
		dist.put(src, 0);
		while (!q.isEmpty()) {
			T node = q.peek();
			System.out.print(node + " ");
			q.poll();
			// for the neighbours of current node, find out the nodes which are not visited
			Iterator<T> i = map.get(node).listIterator();

			while (i.hasNext()) {
				T neighbour = i.next();
				if (dist.get(neighbour) == Integer.MAX_VALUE) {
					q.add(neighbour);
					dist.put(neighbour, dist.get(node) + 1);
				}
			}

		}

		for (Map.Entry<T, Integer> entry : dist.entrySet()) {
			System.out.println("node = " + entry.getKey() + ", dist = " + entry.getValue() + " from src");
		}
	}
}

public class SingleSourceShortestPath {

	public static void main(String args[]) {

		// Object of graph is created.
		GraphGenII<Integer> g = new GraphGenII<>();
		g.addEdge(0, 1, true);
		g.addEdge(1, 2, true);
		g.addEdge(3, 0, true);
		g.addEdge(3, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(4, 5, true);
		

		g.bfs(0);

	}
}

