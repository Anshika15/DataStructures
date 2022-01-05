/*

Group Shifted String

1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other. 
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Note -> Every string consists of lower-case English letters only.

*/

import java.util.*;

public class Main {
    
    public static String getKey(String str)
    {
        String key = "";
        
        for(int i = 1; i < str.length(); i++)
        {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            int diff = curr - prev;
            
            if(diff < 0)
                diff += 26;
                
            key += diff + "#";
        }
        key += '.';
        return key;
    }

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		
		/* key  will be built using difference between immediate difference between ASCII vals of chars */
		/* if the subtractin between two ascii chars is negative then add 26 in it */
		
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for(String str : strs)
		{
		    String key = getKey(str);
		    if(!map.containsKey(key))
		    {
		       ArrayList<String> list = new ArrayList<>();
		       list.add(str);
		       map.put(key, list);
		    }
		    else
		    {
		       ArrayList<String> list = map.get(key);
		       list.add(str);
		    }
		}
		
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		for(ArrayList<String> list: map.values())
		{
		    res.add(list);
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
