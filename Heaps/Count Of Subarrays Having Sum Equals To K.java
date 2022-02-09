/* 

Count Of Subarrays Having Sum Equals To K

1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum equals k.


*/

import java.util.*;

public class Main {

	public static int solution(int[] arr, int target){
		HashMap<Integer, Integer> map = new HashMap<>(); // prefix sum, freq

        map.put(0, 1);
        int sum = 0;
        int count = 0;
		for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];

            if(map.containsKey(sum - target))
            {
                count += map.get(sum - target);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
