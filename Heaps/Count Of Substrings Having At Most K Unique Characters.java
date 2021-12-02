import java.util.*;

public class Main {

	public static int solution(String str, int k) {
		int ans = 0;
		
		int i = -1;
		int j = -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true)
		{
		    boolean flag1 = false;
		    boolean flag2 = false;
		    
		    while(i < str.length()-1)
		    {
		        i++;
		        flag1 = true;
		        char ch = str.charAt(i);
		        map.put(ch, map.getOrDefault(ch, 0)+1);
		        if(map.size() <= k)
		        {
		            ans += i-j;
		        }
		        else
		        {
		            break;
		        }
		        
		    }
		    
		    if(i == str.length() - 1 && map.size() <= k)
		        break;
		    
		    while(j < i)
		    {
		        j++;
		        flag2 = true;
		        char ch = str.charAt(j);
		        if(map.get(ch) == 1)
		            map.remove(ch);
		        else
		            map.put(ch,map.get(ch)-1);
		            
		        if(map.size() > k)
		        {
		            continue;
		        }
		        else
		        {
		            ans += i-j;
		            break;
		        }
		    }
		    
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
