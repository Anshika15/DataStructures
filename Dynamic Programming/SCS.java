/*
 * Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both,
 *  X and Y as its sub-sequences.
 
 */

import java.util.*;

public class SCS {
	
	public static int shortestCommonSupersequence(String X, String Y, int m, int n)
	{
	    //Your code here
	    return (m + n - lcs(X, Y, m, n));
	    
	}

	public static int lcs(String s1, String s2, int m, int n)
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
	    return t[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		System.out.println("Length of Shortest Commmon subsequence: " + shortestCommonSupersequence(s1, s2, s1.length(), s2.length()));

	}

}

