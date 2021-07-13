import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
	    
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    int m = s.nextInt();
	    
	    int edges[][] = new int[m][3];
	    
	    for(int i = 0; i < m; i++)
	    {
	        edges[i][0] = s.nextInt();
	        edges[i][1] = s.nextInt();
	        edges[i][2] = s.nextInt();
	    }
	    
	    int path[] = new int[n];
	    
	    Arrays.fill(path, Integer.MAX_VALUE);
	    path[0] = 0;
	    
	    for(int i = 0; i < n-1; i++)
	    {
	        for(int j = 0; j < m; j++)
	        {
	            int u = edges[j][0];
	            int v = edges[j][1];
	            int wt = edges[j][2];
	            if(path[u] == Integer.MAX_VALUE)
	                continue;
	                
	            if(path[u]+wt < path[v])
	            {
	                path[v] = path[u]+wt;
	            }
	        }
	    }
	    
	    int flag = 0;
	    
	    for(int j = 0; j < m; j++)
	        {
	            int u = edges[j][0];
	            int v = edges[j][1];
	            int wt = edges[j][2];
	            if(path[u] == Integer.MAX_VALUE)
	                continue;
	                
	            if(path[u]+wt < path[v])
	            {
	                flag = 1;
	                System.out.println("1");
	                break;
	            }
	        }
	    
	    if(flag == 0)
	        System.out.println("0");
		
	}
}