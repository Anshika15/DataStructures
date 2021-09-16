import java.util.*;

public class Main {

	public static int solution(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
        
        int res = 0;
        int i = -1;
        int j = -1;
        while(true)
        {
            boolean flag1 = false;
            boolean flag2 = false;
            // acquire
            while(i < s.length() - 1)
            {
                flag1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                if(map.get(ch) == 2)
                    break;
                else
                {
                    int len = i - j;
                    if(len > res)
                        res = len;
                }
                
            }
            
            // release
            while(j < i)
            {
                flag2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 1)
                    break;
                
            }
            
            if(flag1 == false && flag2 == false)
                break;
        }
        
        return res;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
