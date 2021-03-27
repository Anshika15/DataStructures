import java.util.ArrayList;

public class ImplementGraphAdjacencyList {

	int v;
	ArrayList<Integer> arr[];
	public ImplementGraphAdjacencyList(int v) {
		this.v = v;
		arr = new ArrayList[v];
		for(int i = 0; i < v; i++)
		{
			arr[i] = new ArrayList<>();
		}
	}
		
	public void addEdge(int u, int v, boolean bidir) {
		arr[u].add(v);
		if(bidir)
		{
			arr[v].add(u);
		}
	}
	
	public void printAdjList() {
		for(int i = 0; i < v; i++)
		{
			System.out.println(i + " - " + arr[i]);
		}
	}

	public static void main(String[] args) {
		
		ImplementGraphAdjacencyList graph = new ImplementGraphAdjacencyList(5);
		graph.addEdge(0, 1, true);
		graph.addEdge(0, 4, true);
		graph.addEdge(4, 3, true);
		graph.addEdge(1, 4, true);
		graph.addEdge(1, 2, true);
		graph.addEdge(2, 3, true);
		graph.addEdge(1, 3, true);
		
		graph.printAdjList();

	}

}

