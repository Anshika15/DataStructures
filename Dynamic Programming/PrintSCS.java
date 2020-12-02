/*
 * Given two strings X and Y, 
 * print the shortest string that has both X and Y as subsequences.
 *  If multiple shortest supersequence exists, print any one of them.
 */

import java.util.*;
public class PrintSCS {
	
	static String scs(String s1, String s2, int m, int n)
	{
	    int t[][] = new int[m+1][n+1];
	    for(int i = 0; i < m+1; i++)
	    {
	        for(int j = 0; j < n+1; j++)
	        {
	            if(i == 0 || j == 0)
	            t[i][j] = 0;
	        }
	    }
	    
	     for(int i = 1; i < m+1; i++)
	    {
	        for(int j = 1; j < n+1; j++)
	        {
	            if(s1.charAt(i-1) == s2.charAt(j-1))
	            {
	                t[i][j] = 1 + t[i-1][j-1];
	            }
	            else
	            {
	                t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
	            }
	        }
	    }
	     int i = m, j = n;
	     StringBuilder str = new StringBuilder();
	     while(i > 0 && j > 0)
	     {
	    	 if(s1.charAt(i-1) == s2.charAt(j-1))
	    	 {
	    		 str.append(s1.charAt(i-1));
	    		 i--;
	    		 j--;
	    	 }
	    	 else
	    	 {
	    		 if(t[i][j-1] > t[i-1][j])
	    		 {
	    			 str.append(s2.charAt(j-1));
	    			 j--;
	    		 }
	    		 if(t[i][j-1] < t[i-1][j])
	    		 {
	    			 str.append(s1.charAt(i-1));
	    			 i--;
	    		 }
	    	 }
	     }
	     
	     while(i > 0)
	     {
	    	 str.append(s1.charAt(i-1));
	    	 i--;
	     }
	     
	     while(j > 0)
	     {
	    	 str.append(s2.charAt(j-1));
	    	 j--;
	     }
	     
	     return str.reverse().toString();
	 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		s.close();
		System.out.println("Shortest Commmon subsequence: " + scs(s1, s2, s1.length(), s2.length()));
	}

}

