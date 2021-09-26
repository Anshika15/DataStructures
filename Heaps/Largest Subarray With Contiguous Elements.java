/*
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).
*/

import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
		int ans = 0;
		
		for(int i = 0; i < arr.length -1; i++)
		{
		    int min = arr[i];
		    int max = arr[i];
		    HashSet<Integer> set = new HashSet<>();
		    set.add(arr[i]);
		    for(int j = i+1; j < arr.length; j++)
		    {
                if(set.contains(arr[j]))
                    break;
                set.add(arr[j]);
                min = Math.min(arr[j], min);
                max = Math.max(arr[j], max);
                if(max - min == j - i){
                int len = j - i + 1;
                if(len > ans)
                    ans = len;
                }
		    }
		}
		
		return ans;

	//	return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
