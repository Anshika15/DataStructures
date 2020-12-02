/*
Given two strings X and Y. The task is to find the length of the longest common substring.
Input:
First line of the input contains number of test cases T. Each test case consist of three lines, 
first of which contains 2 space separated integers N and M denoting the size of string X and Y strings respectively. 
The next two lines contains the string X and Y.
Output:
For each test case print the length of longest  common substring of the two strings.
 */

import java.util.*;
public class LCSubString {
	
	static int LCSubstring(String s1, String s2, int n, int m)
    {
        int result = 0;
        int t[][] = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++)
        {
            for(int j = 0; j < m+1; j++)
            {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < m+1; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1 + t[i-1][j-1];
                    result = Math.max(result, t[i][j]);
                }
                else
                {
                    t[i][j] = 0;
                }
            }
        }
        
        return result;
    }
    
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0)
		{
		    
		    int n = s.nextInt();
		    int m = s.nextInt();
		    String s1 = s.next();
		    String s2 = s.next();
		    System.out.println(LCSubstring(s1, s2, n, m));
		}
	}

}

