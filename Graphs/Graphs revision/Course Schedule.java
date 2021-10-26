import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            g.add(new ArrayList<>());
        }
        int m = s.nextInt();
        for(int i = 0; i < m; i++)
        {
            int v = s.nextInt();
            int u = s.nextInt();
            
            g.get(u).add(v); //in the portal the edge v is given before u
        }
        
        int res[] = findOrder(g);
        // as we are already adding edges in reverse therefore, no need to reverse the o/p
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i] + " ");
        }
        
	}
	
	public static int[] findOrder(ArrayList<ArrayList<Integer>> g)
	{
	    int[] indegree = new int[g.size()];
	    for(int i = 0; i < g.size(); i++)
	    {
	        for(int e : g.get(i))
	        {
	            indegree[e]++;
	        }
	    }
	    
	    LinkedList<Integer> q = new LinkedList<Integer>();
	    for(int i = 0; i < indegree.length; i++)
	    {
	        if(indegree[i] == 0)
	            q.add(i);
	    }
	    int res[] = new int[g.size()];
	    int idx = 0;
	    while(q.size() > 0)
	    {
	        int rem = q.removeFirst();
	        res[idx] = rem;
	        idx++;
	        for(int e : g.get(rem))
	        {
	            indegree[e]--;
	            if(indegree[e] == 0)
	                q.add(e);
	        }
	    }
	    
	    if(idx == g.size())
	        return res;
	    return new int[]{-1};
	}
}
