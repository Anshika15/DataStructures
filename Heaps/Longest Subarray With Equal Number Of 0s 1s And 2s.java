/*

Longest Subarray With Equal Number Of 0s 1s And 2s

1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.

*/
import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        
        /*
        
        key => s21#s10 where s21 = number of 2s - number of 1s 
                            s10 = number of 1s - number of 0s
        if this key repeats itself => there is a subarray in between with equal number of 0s, 1s and 2s.
        
        */
        
        int ans = 0;

        HashMap<String, Integer> map = new HashMap<>();
        
        int s0 = 0;
        int s1 = 0;
        int s2 = 0;
        
        String key = (s2-s1) + "#" + (s1-s0);
        map.put(key, -1); // key and index
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0)
                s0++;
            else if(arr[i] == 1)
                s1++;
            else
                s2++;
            key = (s2-s1) + "#" + (s1-s0);
            if(map.containsKey(key))
            {
               int len = i - map.get(key);
               ans = Math.max(ans, len);
            }
            else
            {
                map.put(key, i);
            }
            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
