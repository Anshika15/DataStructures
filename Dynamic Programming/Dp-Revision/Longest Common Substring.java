import java.io.*;
import java.util.*;

public class Main {

    /* compare all prefixes of s1 with all prefixes of s2 and find longest common subseq */
	public static int solution(String s1, String s2){
		//write your code here

        int res = 0;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
