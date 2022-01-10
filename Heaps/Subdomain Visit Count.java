/*
Subdomain Visit Count
1. A website domain like "www.pepcoding.com" consists of various subdomains like 
   "com" at the topmost level, "pepcoding.com" at the next level, and "www.pepcoding.com" at the lowest level.
2. When you visit a domain like "www.pepcoding.com", you will also visit its parent domains "pepcoding.com" and "com".   
3. You are given N number of strings where every string contains a number and a domain separated by a space, where the number represents the visit count of the domain.
4. You have to find the number of visits for each sub-domain.
*/
import java.util.*;

public class Main {
    
	public static List<String> subdomainVisits(String[] cpdomains) {
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String domain : cpdomains)
		{
		    String temp[] = domain.split(" ");
		    int visCount = Integer.parseInt(temp[0]);
		    
		    String words[] = temp[1].split("\\.");
		    
		    StringBuilder sb = new StringBuilder();
		    for(int idx = words.length-1; idx >= 0; idx--)
		    {
		        if(idx == words.length - 1)
		        {
		            sb.append(words[idx]);
		        }
		        else
		        {
		            sb.insert(0, ".");
		            sb.insert(0, words[idx]);
		        }
		        
		        String subDomain = sb.toString();
		        
		        map.put(subDomain, map.getOrDefault(subDomain,0) + visCount);
		    }
		}
		
		ArrayList<String> res = new ArrayList<>();
		
		for(String key : map.keySet())
		{
		    StringBuilder sb = new StringBuilder();
		    sb.append(map.get(key));
		    sb.append(" ");
		    sb.append(key);
		    res.add(sb.toString());
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] cpd = new String[n];
		for (int i = 0; i < cpd.length; i++) {
			cpd[i] = s.nextLine();
		}
		List<String> ans = subdomainVisits(cpd);
		Collections.sort(ans);
		for(int i = 0; i < ans.size(); i++)
		       System.out.println(ans.get(i));
	}

}
