/*
 	Minimum number of deletions to make a string palindrome.
 */
import java.util.*;

public class MinDel {
	static int del(String str)
	{
		return (str.length() - lps(str));
	}
	static int lps(String str)
	{
		StringBuilder sb = new StringBuilder(str);
		return lcs(str,sb.reverse().toString(), str.length());
	}
	
	static int lcs(String str1, String str2, int n)
	{
		int t[][] = new int[n+1][n+1];
		for(int i = 0; i < n+1; i++)
		{
			for(int j = 0; j < n+1; j++)
			{
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for(int i = 1; i < n+1; i++)
		{
			for(int j = 1; j < n+1; j++)
			{
				if(str1.charAt(i-1) == str2.charAt(j-1))
				{
					t[i][j] = 1 + t[i-1][j-1];
				}
				else
				{
					t[i][j] = Math.max(t[i-1][j],  t[i][j-1]);
				}
			}
		}
		return t[n][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			int ans = del(str);
			System.out.println("Number of deletions: " + ans);

	}

}

