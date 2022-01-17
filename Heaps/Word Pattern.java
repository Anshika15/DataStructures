/*
Word Pattern

1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.

Note -> Every string consists of lower-case English letters only.

*/
import java.util.*;

public class Main {

	public static boolean wordPattern(String pattern, String str) {
	    
	    String[] words = str.split(" ");
	    if(words.length != pattern.length())
            return false;
	    
		HashMap<Character, String> map = new HashMap<>();
		
		HashMap<String, Boolean> used = new HashMap<>();
		
		for(int i = 0; i < pattern.length(); i++)
		{
		    char ch = pattern.charAt(i);
		    if(!map.containsKey(ch))
		    {
		       if(used.containsKey(words[i]))
		            return false;
		       else
		        {
		            map.put(ch, words[i]);
		            used.put(words[i], true);
		        }
		    }
		    else
		    {
		        String word = map.get(ch);
		        if(!word.equals(words[i]))
		            return false;
		    }
		    
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

}
