import java.util.*;
	class GraphGenI<T> {

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
		
		void bfs(T src) {
			Queue<T> q = new LinkedList<>();
			Map<T, Boolean> visited = new HashMap<>();
			q.add(src);
			visited.put(src, true);
			while(!q.isEmpty())
			{
				T node = q.peek();
				System.out.print(node + " ");
				q.poll();
				// for the neighbours of current node, find out the nodes which are not visited
				 Iterator<T> i = map.get(node).listIterator();
				while(i.hasNext())
				{
					T neighbour = i.next();
					if(!visited.getOrDefault(neighbour, false))
					{
						q.add(neighbour);
						visited.put(neighbour, true);
					}
				}
				
			}
		}
	}
	 
	public class BreadthFirstSearch {

		public static void main(String args[])
		{

			// Object of graph is created.
			GraphGenI<Integer> g = new GraphGenI<>();
			g.addEdge(0, 1, true);
			g.addEdge(1, 2, true);
			g.addEdge(0, 4, true);
			g.addEdge(2, 4, true);
			g.addEdge(2, 3, true);
			g.addEdge(3, 5, true);
			g.addEdge(3, 4, true);
			
			g.bfs(0);
			
		}
	}

