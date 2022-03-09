/*

Pattern Matching

1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular 
     expressions.

*/

import java.io.*;
import java.util.*;

public class Main {
    
    /*
    
    take each char of pattern then try to map that char with each prefixes
    
    (if char is repated check whether same chars are mapped or not if yes carry on at the end if you got result print it)
    
    */

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		// op here is originalPattern
		
		if(pattern.length() == 0)
		{
		    HashSet<Character> alreadyPrinted = new HashSet<>();
		    if(str.length() == 0)
		    {
		        for(int i = 0; i < op.length(); i++)
		        {
		            char ch = op.charAt(i);
		            if(!alreadyPrinted.contains(ch))
		            {
		               System.out.print(ch + " -> " + map.get(ch) + ", ");
		               alreadyPrinted.add(ch);
		            }
		        }
		        System.out.println(".");
		    }
		    
		    return;
		}
		
		char ch = pattern.charAt(0);
		String rop = pattern.substring(1);
		if(map.containsKey(ch))
		{
		    String prevMap = map.get(ch);
		    if(str.length() >= prevMap.length())
		    {
		        String left = str.substring(0, prevMap.length());
		        String ros = str.substring(prevMap.length());
		        if(prevMap.equals(left))
		        {
		            solution(ros, rop, map, op);
		        }
		    }
		}
		else
		{ // map it with all prefixes
		    for(int i = 0; i < str.length(); i++)
		    {
		        String prefix = str.substring(0, i+1); // 0 to i
		        String ros = str.substring(i+1); // i to end
		        map.put(ch, prefix);
		        solution(ros, rop, map, op);
		        map.remove(ch);
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}
