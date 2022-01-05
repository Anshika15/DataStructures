/*
Count Of Subarrays With Equal Number Of 0s 1s And 2s

1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find the count of subarrays with equal number of 0s, 1s, and 2s.

*/
import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        
        int ans = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int s0 = 0;
        int s1 = 0;
        int s2 = 0;
        
        String key = (s2-s1) + "#" + (s1-s0);
        map.put(key, 1); // key, freq

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
               ans += map.get(key);
               map.put(key, map.get(key)+1);
            }
            else
            {
                map.put(key, 1);
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
