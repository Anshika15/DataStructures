/*
Valid Anagram

1. You are given two strings s1 and s2.
2. You have to determine if s2 is an anagram of s1.
*/
import java.util.*;

public class Main {
	
	public static boolean solution(String s1, String s2){
		
		if(s1.length() != s2.length())
		  return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s1.length(); i++)
		{
		   map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1); 
		}
		
		for(int i = 0; i < s2.length(); i++)
		{
		    char ch = s2.charAt(i);
		    if(map.containsKey(ch))
		    {
		        if(map.get(ch) == 1)
		            map.remove(ch);
		        else
		            map.put(ch, map.get(ch)-1);
		    }
		    else
		    {
		        return false;
		    }
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
