/*

Isomorphic Strings

1. You are given two strings s1 and s2.
2. You have to determine if they are isomorphic or not.
3. Two strings are called isomorphic if -
   -> Every character of s1 can be mapped with characters of s2.
   -> A character of s1 can be mapped to only one character.
   -> All occurrences of a character must be replaced with another character while preserving the order of characters.

Note -> Length of s1 is equal to the length of s2.
*/

import java.util.*;

public class Main {

	public static boolean isIsomorphic(String s, String t) {
	
	    if(s.length() != t.length())
	        return false;
	        
	    HashMap<Character, Character> map1 = new HashMap<>(); // to map s1 char with s2 char

        HashMap<Character, Boolean> map2 = new HashMap<>(); // whether we can use s2 chars or not.
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1))
            {
                if(map1.get(ch1) != ch2)
                    return false;
            }
            else
            {
                if(map2.containsKey(ch2)){
                    return false;
                }
                else
                {
                    map1.put(ch1, ch2); // map the char 1 with char2
                    map2.put(ch2, true); // marks char2 as visited
                }
            }
        }
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

}
