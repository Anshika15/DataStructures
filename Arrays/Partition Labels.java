/* 

Partition Labels

1. A string 's' of lowercase English letters is given. 
2. We want to partition this string into as many parts as possible so that each letter appears in at most one part.
3. Return a list of integers representing the size of these parts.

*/

import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
  public static List<Integer> partitionLabels(String s) {
      HashMap<Character, Integer> map = new HashMap<>(); // char, last index
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        List<Integer> res = new ArrayList<>();
        
        int max = 0;
        int prev = -1;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if(max == i)
            {
                res.add(max - prev);
                prev = max;
            }
        }
        
        return res;
  }

  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    List<Integer> res = partitionLabels(str);
    for (int val : res) {
      System.out.print(val + " ");
    }
  }
}
