import java.io.*;
import java.util.*;

public class Main {

    /* O(n^3) solution */
/*	public static int minPalindromicCut(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];// whether the string is palindrome or not
		
		for(int g = 0; g < s.length(); g++)
		{
		    for(int i = 0, j = g; j < dp.length; i++, j++)
		    {
		        if(g == 0)
		        {
		            dp[i][j] = true;
		        }
		        else if(g == 1)
		        {
		            dp[i][j] = s.charAt(i) == s.charAt(j);
		        }
		        else
		        {
		            if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
		                dp[i][j] = true;
		            else
		                dp[i][j] = false;
		        }
		    }
		}
		
		int[][] dp2 = new int[s.length()][s.length()];
		for(int g = 0; g < s.length(); g++)
		{
		    for(int i = 0, j = g; j < dp2.length; i++,j++)
		    {
		        if(g == 0)
		        {
		            dp2[i][j] = 0;
		        }
		        else if(g == 1)
		        {
		            if(s.charAt(i) == s.charAt(j))
		                dp2[i][j] = 0;
		            else
		                dp2[i][j] = 1;
		        }
		        else
		        {
		            if(dp[i][j])
		                dp2[i][j] = 0;
		            else
		            {
		                int min = Integer.MAX_VALUE;
		               for(int k = i; k < j; k++)
		               {
		                   int left = dp2[i][k];
		                   int right = dp2[k+1][j];
		                   
		                   min = Math.min(min, left+right+1);
		               }
		               dp2[i][j] = min;
		            }
		        }
		    }
		}
		
		return dp2[0][s.length()-1];
	}
*/

    /* O(n^2) Solution */
	public static int minPalindromicCut(String s) {
	    
	    boolean[][] dp = new boolean[s.length()][s.length()];// whether the string is palindrome or not
		
		for(int g = 0; g < s.length(); g++)
		{
		    for(int i = 0, j = g; j < dp.length; i++, j++)
		    {
		        if(g == 0)
		        {
		            dp[i][j] = true;
		        }
		        else if(g == 1)
		        {
		            dp[i][j] = s.charAt(i) == s.charAt(j);
		        }
		        else
		        {
		            if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
		                dp[i][j] = true;
		            else
		                dp[i][j] = false;
		        }
		    }
		}
		
		int res[] = new int[s.length()];
		res[0] = 0;
		for(int j = 1; j < res.length; j++)
		{
		    if(dp[0][j]){
		        res[j] = 0;
		    }
		    else{
    		    int min = Integer.MAX_VALUE;
    		    for(int i = j; i >= 1; i--)
    		    {
    		        if(dp[i][j])
    		        {
    		          min = Math.min(min, res[i-1]);
    		        }
    		    }
    		    res[j]= min+1;
		    }
		}
	    return res[res.length-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}
