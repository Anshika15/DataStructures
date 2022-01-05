/*
Count Of Subarrays With Equal Number Of Zeroes And Ones

1. You are given an array that contains only 0s and 1s.
2. You have to find the count of subarrays with equal number of 0s and 1s.

*/
import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        
        /* for arr[i] == 1 sum+= 1 and for arr[i] == 0 sum += -1 */
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //sum , count;

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
               ans += map.get(sum);
               map.put(sum, map.get(sum)+1);
            }
            else
            {
                map.put(sum ,1);
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
