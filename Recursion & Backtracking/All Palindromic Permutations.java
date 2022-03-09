import java.io.*;
import java.util.*;

public class Main {
    /* 
    
    create frequency map 
    
    then half the frequency if it is even, if it is odd        half it and keep it aside also
    
    find permutations of that map , put the char left aside (whose freq was odd) , then put the string in reverse(string here is the permutation generated)
    
    ---------->> if odd freq char is greater than 1, then its plaindrome partitioning is not possible <<-------------
    
    eg; if map is a4b4c3
    then generate permuations for a2b2c1 + c + reverseOf(permutation generated);
    
    */
    

    // current spot, total spot, freq map, odd char, answer so far
	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
	    
	    if(cs > ts)
	    {
	        String rev = "";
	        for(int i = asf.length() - 1; i >= 0; i--)
	        {
	            rev += asf.charAt(i);
	        }
	        String res = asf;
	        if(oddc != null)
	        {
	            res += oddc;
	        }
	        res += rev;
	        System.out.println(res);
	        return;
	    }
	    
		for(char ch : fmap.keySet())
		{
		    int freq = fmap.get(ch);
		    if(freq > 0){
    		    fmap.put(ch, freq - 1);
    		    generatepw(cs+1, ts, fmap, oddc, asf+ch);
    		    fmap.put(ch, freq);
		    }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		Character odd = null;
		int odds = 0;
		int len = 0;
		
		for(char ch : fmap.keySet())
		{
		    int freq = fmap.get(ch);
		    
		    if(freq % 2 == 1)
		    {
		        odd = ch;
		        odds++;
		    }
		    fmap.put(ch, freq/2);
		    len += freq / 2;
		}
		if(odds > 1)
		{
		    System.out.println("-1");
		    return;
		}
		generatepw(1, len, fmap, odd, "");
	}
	
}
