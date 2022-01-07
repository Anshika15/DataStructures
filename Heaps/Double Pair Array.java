/*

Double Pair Array

1. You are given an array(arr) of integers with even length N.
2. You have to tell if it is possible to re-order the given array such that for every i in range [0,N/2)
   arr[2*i + 1] = 2 * arr[2*i], this condition holds true.
   
*/

import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        /* logic => we will sort the array and then find out whether the double value elemnt exists or not 
        we will use hashmap to store the freq of elemnts as each time traversing the array to find double element will increase complexity
        moreover sorting will be done based on abs value as for negative values we will not be able to find twice the elemnt as we will be moving in one direction only */
        
        HashMap<Integer, Integer> map = new HashMap<>(); // freq map
        
        for(int i = 0; i < arr.length; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        Integer array[] = new Integer[arr.length]; // took Integer array so that we can sort using lambda function
        
        for(int i = 0; i < arr.length; i++)
            array[i] = arr[i];
        Arrays.sort(array, (a,b)->{
            return Math.abs(a) - Math.abs(b);
        });
        
        for(Integer val : array)
        {
            if(map.get(val) == 0)
                continue;
            if(map.getOrDefault(2*val, 0) == 0)
                return false;
            else
            {
                map.put(val, map.get(val)-1);
                map.put(val*2, map.get(2*val)-1);
            }
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
