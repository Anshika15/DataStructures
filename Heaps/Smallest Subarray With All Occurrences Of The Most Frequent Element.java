/*

Smallest Subarray With All Occurrences Of The Most Frequent Element

1. You are given an array(arr) of integers.
2. You have to find the element(x) with maximum frequency in the given array. 
3. Also, you have to find the smallest subarray which has all occurrences of the most frequent element i.e x.

Note -> If there are two or more elements with maximum frequency and the same subarray size then print the subarray which occurs first in the given array.
*/

import java.util.*;

public class Main {

    public static void solution(int[] arr) {
        /* logic => create two maps
           one for storing the starting index of occurence of element
           one sor storing the freq of an element
           we will start calculating our result along with it.
        */
        
        HashMap<Integer, Integer> freq = new HashMap<>(); // freq map
        
        HashMap<Integer, Integer> smap = new HashMap<>(); // element, starting index
        
        int startIndex = 0;
        int endIndex = 0;
        int highFreq = 0;
        int len = endIndex - startIndex + 1;
        
        for(int i = 0; i < arr.length; i++)
        {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
            if(!smap.containsKey(arr[i]))
                smap.put(arr[i], i);
            
            /* if freq for curr elemet is greater then our current highest freq update all parameters */
            if(freq.get(arr[i]) > highFreq)
            {
                highFreq = freq.get(arr[i]);
                startIndex = smap.get(arr[i]);
                endIndex = i;
                len = endIndex - startIndex + 1;
            }
            /* if freq is same as our current highest freq we need to check for lower length if the len becomes less for this element then update all parameters */
            else if(freq.get(arr[i]) == highFreq)
            {
                if(i - smap.get(arr[i]) + 1 < len)
                {
                    highFreq = freq.get(arr[i]);
                    startIndex = smap.get(arr[i]);
                    endIndex = i;
                    len = endIndex - startIndex + 1;
                }
            }
        }
        
        System.out.println(arr[startIndex]);
        System.out.println(startIndex);
        System.out.println(endIndex);
        
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                solution(arr);
	}

}
