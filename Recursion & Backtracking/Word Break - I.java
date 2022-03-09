/* 

Word Break - I

1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are 
     present in dictionary.

*/

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		/* 
		
		try all prefixes in the string
		if a prefix is present in dictionary check for rest of substring 

		*/
		
		if(str.length() == 0)
		{
		    System.out.println(ans);
		}
		
		for(int i = 0; i < str.length(); i++)
		{
		    String left = str.substring(0, i+1);
		    if(dict.contains(left))
		    {
		        String right = str.substring(i+1);
		        wordBreak(right, ans + left + " ", dict);
		    }
		}
		
	}
		
}
