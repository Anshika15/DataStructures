import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here
        
        HashMap<String, Boolean> findSrc = new HashMap<>();
        
        for(String str : map.keySet())
        {
            String src = str;
            String dest = map.get(src);
            findSrc.put(dest, false);
            if(!findSrc.containsKey(src))
            {
               findSrc.put(src, true); 
            }
        }
        
        String src = "";
        
        for(String str : map.keySet())
        {
            if(findSrc.get(str) == true)
            {
                src = str;
                break;
            }
        }
        
        while(true)
        {
            if(map.containsKey(src))
            {
                System.out.print(src + " -> ");
                src = map.get(src);
            }
            else
            {
                System.out.println(src + ".");
                break;
            }
        }

	}
}
