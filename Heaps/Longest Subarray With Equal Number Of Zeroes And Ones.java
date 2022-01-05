/*

Longest Subarray With Equal Number Of Zeroes And Ones

1. You are given an array that contains only 0s and 1s.
2. You have to find length of the longest subarray with equal number of 0s and 1s.

*/

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        
        /* logic => we will treat 0 as -1 and while doing summaion if we encounter the same sum again it forms a subarray with equal number of zeroes and ones */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1); // sum , idx
        
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0)
                sum += -1;
            else
                sum += 1;
            if(map.containsKey(sum))
            {
                int len = i- map.get(sum);
                ans = Math.max(ans, len);
            }
            else
            {
                map.put(sum , i);
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
