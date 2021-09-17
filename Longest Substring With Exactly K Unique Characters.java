import java.util.*;

public class Main {

	public static int solution(String str, int k){
		// write your code here
		
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		int ans = 0;
		
		while(true)
		{
		    boolean f1 = false;
		    boolean f2 = false;
		    while(i < str.length() - 1)
		    {
		        f1 = true;
		        i++;
		        char ch = str.charAt(i);
		        
		        map.put(ch, map.getOrDefault(ch, 0)+1);
		        
		        if(map.size() < k)
		        {
		            continue;
		        }
		        else if(map.size() == k)
		        {
		            ans = Math.max(ans, i - j);
		        }
		        else
		        {
		            break;
		        }
		            
		    }
		    
		    while(j < i){
		        f2 = true;
		        j++;
		        char ch = str.charAt(j);
		        
		        if(map.get(ch) == 1)
		            map.remove(ch);
		        else
		            map.put(ch, map.get(ch)-1);
		          
		        if(map.size() > k)
		        {
		            continue;
		        }
		        else if(map.size() == k)
		        {
		            ans = Math.max(ans, i - j);
		            break;
		        }
		    }
		    
		    if(f1 == false && f2 == false)
		        break;
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
