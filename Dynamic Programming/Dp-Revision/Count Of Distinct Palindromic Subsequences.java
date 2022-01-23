/*

Count Of Distinct Palindromic Subsequences

1. You are given a string.
2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.

Note -> String contains only lowercase letters.
          -> The answer will be in the integer range only.
          
          */
          
import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {
		
		/* str = c1mc2 ==> here c1 = character, c2 = character and m = middle part of string
		
		dps == disticnt palindromic Sequence
		if(c1 != c2)
		{
		    dps(c1m) + dps(mc2) - dps(m);
		    suffix + prefix - middle part
		}
		
		if(c1 == c2)
		{
		    // three cases
		    // c1 == c2 == a
		    // a - no a present in middle part - a // ama
		        2dps(m) + 2;
		        
		    // a - one more a in middle part - a  // a---a--a
		        2dps(m)+1;
		        
		    // a - more than one a in middle part - a // a---a---a---a
		        2dps(m) - dps(m') // here m' is equal to middle betweem inner a's
		}
		
		*/
		
		// in prev we will store the previous occurence of that char
		// in next we will store the next occurence of that char
		
		int[][] dp = new int[str.length()][str.length()];
		
		int[] prev = new int[str.length()];
		HashMap<Character, Integer> map = new HashMap<>(); // to store the index of char
		
		for(int i = 0; i < str.length(); i++)
		{
		    char ch = str.charAt(i);
		    
		    if(map.containsKey(ch) == false)
		    {
		        prev[i] = -1;
		    }
		    else
		    {
		        prev[i] = map.get(ch);
		    }
		    map.put(ch, i);
		}
		
		int[] next = new int[str.length()];
		map.clear();
		for(int i = str.length()-1; i >= 0; i--)
		{
		    char ch = str.charAt(i);
		    
		    if(map.containsKey(ch) == false)
		    {
		        next[i] = -1;
		    }
		    else
		    {
		        next[i] = map.get(ch);
		    }
		    map.put(ch, i);
		}
		
		for(int g = 0; g < str.length(); g++)
		{
		    for(int i = 0, j = g; j < str.length(); i++, j++)
		    {
		        if(g == 0)
		        {
		            dp[i][j] = 1;
		        }
		        else if(g == 1)
		        {
		            dp[i][j] = 2;
		        }
		        else
		        {
		            char startChar = str.charAt(i);
		            char endChar = str.charAt(j);
		            
		            if(startChar != endChar)
		            {
		                dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]; // prefix + suffix - middle
		            }
		            else
		            {
		                int nextIdx = next[i]; // get next idx of start char
		                int prevIdx = prev[j]; // get prev index of end char
		                
		                if(nextIdx > prevIdx)
		                {
		                    // case 1
		                    dp[i][j] = 2* dp[i+1][j-1] + 2;
		                }
		                else if(nextIdx == prevIdx)
		                {
		                    // case 2
		                    dp[i][j] = 2*dp[i+1][j-1] + 1;
		                }
		                else
		                {
		                    // case 3
		                    dp[i][j] = 2*dp[i+1][j-1] - dp[nextIdx + 1][prevIdx - 1];
		                }
		            }
		        }
		    }
		}
		
		
		return dp[0][str.length()-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
