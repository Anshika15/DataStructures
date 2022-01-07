/*
Rabbits In The Forest

1. There are some rabbits in the forest and each rabbit has some color.
2. Some(possibly all) rabbits are selected from them and they tell you about the number of other rabbits having the same color as them.
3. You are given an array(arr) that contains the answers of all selected rabbits.
4. You have to find the minimum number of rabbits that could be in the forest.

*/

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
       
       int res = 0;
       
       /* first we will make a frequency map */
       
       HashMap<Integer, Integer> map = new HashMap<>(); // freq map
       
       for(int i = 0; i < arr.length; i++)
       {
           map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
       }
       
       for(int val : map.keySet())
       {
           int groupSize = val+1; // group size = number of similar rabbit s with me i.e = similar rabbit + 1 (for me)
           
           int reportees = map.get(val);
           
           int numOfGropus = (int)Math.ceil(reportees * 1.0 / groupSize * 1.0) * groupSize; 
           
           res += numOfGropus;
       }
       
       return res;
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
