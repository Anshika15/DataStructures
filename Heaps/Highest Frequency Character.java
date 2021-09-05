import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch) + 1);
            }
            else
            {
                map.put(ch, 1);
            }
        }
        
        char res = str.charAt(0);
        for(char ch : map.keySet())
        {
            if(map.get(ch) > map.get(res))
            {
                res = ch;
            }
        }
        
        System.out.println(res);
    }

}
