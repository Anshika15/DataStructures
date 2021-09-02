import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        int m = s.nextInt();
	        ArrayList<String> res = printMazePaths(1,1, n, m);
	        
	        for(String st: res)
	            System.out.println(st);

	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static ArrayList<String> printMazePaths(int sr, int sc, int dr, int dc) {
	        
	        if(sr == dr && sc == dc)
	        {
	           ArrayList<String> sres = new ArrayList<String>();
	           sres.add("");
	           return sres;
	        }
	       
	       ArrayList<String> paths = new ArrayList<>();
	       ArrayList<String> hpaths = new ArrayList<String>();
	       
	       ArrayList<String> vpaths = new ArrayList<String>();
	       
	       
	        if(sc < dc){
	            hpaths = printMazePaths(sr, sc+1, dr, dc);
	        }
	        if(sr < dr){
	           vpaths = printMazePaths(sr+1, sc, dr, dc);
	        }
	        for(String st: hpaths)
	        {
	          paths.add("h"+st);
	        }
	        for(String st: vpaths)
	        {
	          paths.add("v"+st);
	        }
	        
	        return paths;
	        
	    }

	}
