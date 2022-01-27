/* 

K Concatenation

1. You are given an array(arr1) of integers and an integer k.
2. Another array(arr2) is formed by concatenating K copies of arr1.
   For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
3. You have to find the maximum subarray sum in arr2.

*/

import java.io.*;
import java.util.*;

public class Main {

  public static long solution(int[] arr, int k, long sum) {
    // write your code here
    
    /*
    ==> if sum == 0
    find kadanes for one array
    ==> if sum of array is -ve then find kadanes for two concated array i.e our result;
    ==> if sum of array is +ve then ans = kadanes of two concated array + (k-2)sum
    */
    
    if(k == 1)
        return kadanes(arr);
    else if(sum < 0)
    {
        int[] res = concat(arr);
        return kadanes(res);
    }
    else
    {
        int res[] = concat(arr);
        return kadanes(res) + (k-2)*sum;
    }

   // return 0;
  }
  
  public static int[] concat(int[] arr)
  {
      int res[] = new int[2*arr.length];
      int j = 0;
      for(int i = 0; i < arr.length; i++)
      {
        res[j] = arr[i];
        j++;
      }
      for(int i = 0; i < arr.length; i++)
      {
        res[j] = arr[i];
        j++;
      }
      return res;
  }
  
  public static long kadanes(int[] arr)
  {
      if(arr.length == 0)
        return 0;
      long maxSum = arr[0];
      long currSum = arr[0];
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
          maxSum = Math.max(currSum, maxSum);
      }
      return maxSum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }

}
