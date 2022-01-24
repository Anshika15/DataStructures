import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String s, String p) {
		
		boolean dp[][] = new boolean[p.length()+1][s.length() + 1];
		
		/* for first row & col ans is true as blank pattern matches blank string */
		/* for rest of first row ans is false */
		/* for first col if pattern is * then we check two row above i.e i-2 if true then true else false 
		   for rest of chars in first col ans is false */
		
		/* if s != p put false */
		/* if s == p check i-1,j-1 i.e diagonal */
		/* if p == * then we there are two case:- 
		case 1 = when prev char of pattern is same as curr character of string then check two rows above and 1 column to left
		
		case 2 = we check only for two row above
		*/
		
		for(int i = 0; i <= p.length(); i++)
		{
		    for(int j = 0; j <= s.length(); j++)
		    {
		        if(i == 0 && j == 0)
		        {
		            dp[i][j] = true;
		        }
		        else if(i == 0)
		        {
		            dp[i][j] = false;
		        }
		        else if(j == 0)
		        {
		            if(p.charAt(i-1) == '*')
		            {
		                dp[i][j] = dp[i-2][j];
		            }
		            else
		            {
		                dp[i][j] = false;
		            }
		        }
		        else
		        {
		             char pc = p.charAt(i-1);
		             char sc = s.charAt(j-1);
		             
		             if(pc == '*')
		             {
		                dp[i][j] = dp[i-2][j];
		                
		                char pSecondLast = p.charAt(i-2);
		                if(pSecondLast == '.' || pSecondLast == sc)
		                {
		                    dp[i][j] = dp[i][j] || dp[i][j-1];
		                }
		                
		             }
		             else if(pc == '.')
		             {
		                dp[i][j] = dp[i-1][j-1]; 
		             }
		             else if(pc == sc)
		             {
		                dp[i][j] = dp[i-1][j-1]; 
		             }
		             else
		             {
		                 dp[i][j] = false;
		             }
		        }
		    }
		}
		
		return dp[p.length()][s.length()];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
