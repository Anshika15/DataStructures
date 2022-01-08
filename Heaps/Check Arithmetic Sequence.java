/*

Check Arithmetic Sequence

1. You are given an array(arr) of integers.
2. You have to find if the elements of the given array can be arranged to form an arithmetic progression.
3. Arithmetic progression is defined as a sequence of numbers where the difference between any two consecutive numbers is the same. 

Note -> Try to solve this in linear time complexity.

*/

import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        /* first find the common difference after that keep on checking whether a1, a2, a3, ... an EXISTS OR NOT */
        
        if(arr.length <= 1)
            return true;
        
        int a0 = Integer.MAX_VALUE; // min element
        int an = Integer.MIN_VALUE; // max element
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            a0 = Math.min(a0, arr[i]);
            an = Math.max(an, arr[i]);
            set.add(arr[i]);
        }
        
        int cd = (an - a0)/ (arr.length - 1);
        
        for(int i = 0; i < arr.length; i++)
        {
            int ai = a0 + i*cd;
            if(!set.contains(ai))
                return false;
        }
        
        
        return true;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
