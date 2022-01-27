/* 
Kadane's Algorithm

1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.

*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr) {
    
    /* 
    Kadane's Algorithm
    
    we will keep two subarrays one is curr subarray and second is maxSubarray
    
    if we get -ve sum from prev element we will create a new subsrray else we will sit on the prev subarray and try to create maxsubarray
    */
    

    int currSum = arr[0];
    int maxSum = arr[0];
    for(int i = 1; i < arr.length; i++)
    {
        if(currSum >= 0)
        {
            currSum += arr[i];
        }
        else
        {
            currSum = arr[i];
        }
        if(currSum > maxSum)
            maxSum = currSum;
    }
    return maxSum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}
