/*
 	Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character 
 	at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 */
import java.util.*;
public class LongestRepeatingSubsequence {
	
	static int lrs(String str)
	{
		String s1 = str;
		String s2 = str;
		int t[][] = new int[str.length() + 1][str.length() + 1];
		
		for(int i = 0; i < str.length() + 1; i++)
		{
			for(int j = 0; j < str.length() + 1; j++)
			{
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i = 1; i < str.length() + 1; i++)
		{
			for(int j = 1; j < str.length() + 1; j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1) && i != j)
					t[i][j] = t[i-1][j-1] + 1;
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		return t[str.length()][str.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println("length of Longest Repeating Subsequence: " + lrs(str));

	}

}

