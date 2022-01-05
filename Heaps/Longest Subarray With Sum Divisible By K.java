/*

Longest Subarray With Sum Divisible By K

1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.

*/

import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        
        /* s1 = kn+x
           s2 = km + x
           s2 - s1 = k(m-n) => divisivble by k
           
           at each position we will keep on dividing sum with k and find remainder. ervery time remainder repeats itself the sum in betwwen that area would be divisble by k */
           
           /* for -ve remainder we will add k in the remainder
           
           reason => eg; lets say 2 as a rem and -5 as a remainder is same;
           proof=> 2 is away from 0 (2 times) and -5 is away from -1 (2 times) if we go as a number line the numbers between -5 and 2 is 7 only for k = 7 => it is divisible by 7 */
           
           
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1); // rem, index
        
        int sum = 0;
        int rem = 0;
        
        for(int idx = 0; idx < arr.length; idx++)
        {
            sum += arr[idx];
            rem = sum%k;
            if(rem < 0)
                rem += k;
            
            if(map.containsKey(rem))
            {
                int index = map.get(rem);
                int len = idx - index;
                ans = Math.max(ans, len);
            }
            else
                map.put(rem, idx);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
