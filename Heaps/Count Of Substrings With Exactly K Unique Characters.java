/* 

Count Of Substrings With Exactly K Unique Characters

1. You are given a string(str) and a number K.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has exactly K unique characters.

*/


import java.util.*;

public class Main {

	public static int solveforkOne(String str)
	{
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
				i++;
				char ch = str.charAt(i);
				f1 = true;
				map.put(ch, map.getOrDefault(ch, 0)+1);

				if(map.size() == 2)
				{
					removeInMap(map, ch);
					i--;
					break;
				}
			}

			while(j < i){
				if(map.size() == 1)
				{
					ans += i - j;

				}
				f2 = true;
				
				j++;
				char ch = str.charAt(j);
				removeInMap(map, ch);
				if(map.size() == 0)
					break;
			}

			if(f1 == false && f2 == false)
				break;
		}
		return ans;
	}

	public static int solution(String str, int k){

		if(k == 1)
		{
			return solveforkOne(str);
		}

		/* we will keep two hashmaps one for the k unique character and one with k-1 unique character */
		/* substrings size would be equal to difference of end points of k & k-1 unique char substring */
		
		HashMap<Character, Integer> map1 = new HashMap<>(); // with exact k
		HashMap<Character, Integer> map2 = new HashMap<>(); // with k-1

		int si = -1; // small i
		int li = -1; // large i
		int j = -1; // release point

		int ans = 0;


		while(true)
		{
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;

			while(li < str.length() - 1)
			{
				li++;
				flag1 = true;
				char ch = str.charAt(li);
				map1.put(ch, map1.getOrDefault(ch,0)+1);

				if(map1.size() == k+1)
				{
					removeInMap(map1, ch);
					li--;
					break;
				}
			}

			while(si < li)
			{
				flag3 = true;
				si++;
				char ch = str.charAt(si);
				map2.put(ch, map2.getOrDefault(ch, 0)+1);
				if(map2.size() == k)
				{
					removeInMap(map2, ch);
					si--;
					break;
				}
			}

			while(j < si)
			{
				if(map1.size() == k && map2.size() == k-1)
				{
					ans += li - si;
				}
				j++;
				flag2 = true;
				char ch = str.charAt(j);

				removeInMap(map1, ch);
				removeInMap(map2, ch);

				if(map2.size() < k-1 || map1.size() < k)
				{
					break;
				}
			}

			if(flag1 == false && flag2 == false && flag3 == false)
				break;
		}
		return ans;
	}

	public static void removeInMap(HashMap<Character, Integer> map, char ch)
	{
		if(map.get(ch) == 1)
			map.remove(ch);
		else map.put(ch, map.get(ch)-1);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
