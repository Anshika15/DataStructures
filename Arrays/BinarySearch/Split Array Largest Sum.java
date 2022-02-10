/* 
Split Array Largest Sum
1. Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
2. Write an algorithm to minimize the largest sum among these m subarrays.

*/


import java.util.*;
import java.io.*;

public class Main {

  public static int splitArray(int[]arr, int m) {
    
    int sum = 0;
    int max = 0;
    for(int i = 0; i < arr.length; i++)
    {
      sum += arr[i];
      max = Math.max(arr[i], max);
    }

    if(arr.length == m)
      return max;

    int lo = max;
    int hi = sum;
    int ans = 0;
    while(lo <= hi)
    {
      int mid = lo + (hi - lo)/2;

      if(isPossible(mid, arr, m))
      {
        ans = mid;
        hi = mid-1;
      }
      else
      {
        lo = mid+1;
      }
    }
    return ans;
  }


  public static boolean isPossible(int distributions, int[] arr, int minReq)
  {
    int sa = 1;
    int sum = 0;
    for(int i = 0; i < arr.length; i++)
    {
      sum += arr[i];

      if(sum > distributions)
      {
        sa++;
        sum = arr[i];
      }
    }
    return sa <= minReq;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = splitArray(arr, m);
    System.out.println(ans);
  }
}
