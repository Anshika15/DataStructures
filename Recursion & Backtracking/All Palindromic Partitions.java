/*

All Palindromic Partitions

1. You are given a string of length n.
2. You have to partition the given string in such a way that every partition is a palindrome.

*/

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String asf) {
        
        /* we will keep on breaking our question based on the prefix(if prefix string is plaindrome) */
        
        if(str.length() == 0)
        {
            System.out.println(asf);
            return;
        }
        
        for(int i = 0; i < str.length(); i++)
        {
            String prefix = str.substring(0, i+1);
            String ros = str.substring(i+1);
            if(isPalindrome(prefix))
            {
                solution(ros, asf + "(" + prefix + ") ");
            }
        }
        
	}
	
	public static boolean isPalindrome(String str)
	{
	    int left = 0;
	    int right = str.length() -1;
	    while(left < right)
	    {
	        char l = str.charAt(left);
	        char r = str.charAt(right);
	        if(l != r)
	            return false;
	        left++;
	        right--;
	    }
	    return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}
