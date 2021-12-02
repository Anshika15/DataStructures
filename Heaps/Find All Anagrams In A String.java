
/*
1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.

Note -> Both s1 ad s2 consist of lowercase English letters only.
*/
import java.util.*;

public class Main {
	public static void findAnagrams(String s, String p) {
	    /* s is source */
	    /* p is pattern */
        
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++)
        {
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0)+1);
        }
        
        for(int i = 0; i < p.length(); i++)
        {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0)+1);
        }
        
        int i = p.length();
        int count = 0;
        String ans = "";
        while(i < s.length())
        {
            if(comp(smap, pmap) == true){
                count++;
                ans += (i - p.length()) + " ";
            }
            
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0)+1);
            
            char chrem = s.charAt(i - p.length());
            if(smap.get(chrem) == 1)
                smap.remove(chrem);
            else
                smap.put(chrem, smap.get(chrem)-1);
            i++;
        }
        
        if(comp(smap, pmap) == true)
        {
            count++;
            ans += (i - p.length()) + " ";
        }
        System.out.println(count);
        System.out.println(ans);
        
	}

    public static boolean comp(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap)
    {
        for(char ch: smap.keySet())
        {
            if(pmap.getOrDefault(ch,0) != smap.get(ch))
            {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}
