import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str1, String str2) {
		//write your code here
		
		int n = str1.length();
		
		int[][] dptrue = new int[n][n];
		int[][] dpfalse = new int[n][n];
		
		for(int g = 0; g < n; g++)
		{
		    for(int i = 0, j = g; j < n; i++, j++)
		    {
		        if(g == 0)
		        {
		           char ch = str1.charAt(i);
		           if(ch == 'T')
		           {
		               dptrue[i][j] = 1;
		               dpfalse[i][j] = 0;
		           }
		           else if(ch == 'F')
		           {
		               dptrue[i][j] = 0;
		               dpfalse[i][j] = 1;
		           }
		        }
		        else
		        {
		            for(int k = i; k < j; k++)
		            {
		                char optr = str2.charAt(k);
		                int leftT = dptrue[i][k];
		                int rightT = dptrue[k+1][j];
		                int leftF = dpfalse[i][k];
		                int rightF = dpfalse[k+1][j];
		                
		                if(optr == '&')
		                {
		                    dptrue[i][j] += leftT*rightT;
		                    dpfalse[i][j] += leftF*rightF + leftF*rightT + leftT*rightF;
		                }
		                else if(optr == '|')
		                {
		                   dptrue[i][j] += leftT*rightT + leftT*rightF + leftF*rightT;
		                   dpfalse[i][j] += leftF*rightF;
		                }
		                else if(optr == '^')
		                {
		                   dptrue[i][j] += leftT*rightF + leftF*rightT;
		                   dpfalse[i][j] += leftF*rightF + leftT*rightT;
		                }
		            }
		        }
		    }
		}

		return dptrue[0][n-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}
