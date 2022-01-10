/*

First Non-repeating Character

1. You are given a string.
2. You have to find the index of the first non-repeating character in the given string.
3. If no such character exists, print "-1".

*/

import java.util.*;

public class Main {
	
/*	public static int solution(String s) {
	
	    int[] freq = new int[256];
	    for(int i = 0; i < s.length(); i++)
	        freq[s.charAt(i)]++;
	    for(int i = 0; i < s.length(); i++)
	        if(freq[s.charAt(i)] == 1)
	            return i;
   
		return -1;
	 }
*/	 
	 /* using hasmap */
	 
	 public static int solution(String s) {
	
	    HashMap<Character, Integer> map = new HashMap<>();
	    for(int i = 0; i < s.length(); i++)
	        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
	    for(int i = 0; i < s.length(); i++)
	        if(map.getOrDefault(s.charAt(i), 0) == 1)
	            return i;
   
		return -1;
	 }
	 
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s= scn.next();
		System.out.print(solution(s));
	}

}
