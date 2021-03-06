/*
 *  Given two sequences, find the length of longest subsequence present in both of them. 
 */

import java.util.*;
public class LCS {
	
	static int lcs(int p, int q, String s1, String s2){
        // your code here
        int t[][] = new int[p+1][q+1];
        for(int i = 0; i < p+1; i++)
        {
            for(int j = 0; j < q+1; j++)
            {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        
        for(int i = 1; i < p+1; i++)
        {
            for(int j = 1; j < q+1; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[p][q];
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		System.out.println("Length of longest common subsequence is: " + lcs(s1.length(),s2.length(), s1, s2));

	}

}

