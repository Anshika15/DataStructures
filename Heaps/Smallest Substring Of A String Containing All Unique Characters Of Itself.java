import java.util.*;

public class Main {

	public static int solution(String str){
		// write your code here
		
		HashSet<Character> set = new HashSet<>();
		for(char ch : str.toCharArray())
		{
		    set.add(ch);
		}
		
		int size = str.length();
		int i = -1;
		int j = -1;
		HashMap<Character, Integer> map = new HashMap<>(); // char, freq
		
		while(true)
		{
		    boolean f1 = false;
		    boolean f2 = false;
		    
		    // acquire
		    while(i < str.length() - 1 && map.size() < set.size())
		    {
		        f1 = true;
		        i++;
		        char ch = str.charAt(i);
		        
		        map.put(ch, map.getOrDefault(ch, 0)+1);
		    }
		    
		    // release
		    while(j < i && map.size() == set.size())
		    {
		        f2 = true;
		        int plen = i - j;
		        if(plen < size)
		            size = plen;
		        j++;
		        char ch = str.charAt(j);
		        if(map.get(ch) == 1)
		            map.remove(ch);
		        else
		            map.put(ch, map.get(ch)-1);
		    }
		    
		    if(f1 == false && f2 == false)
		        break;
		}
		
		return size;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
