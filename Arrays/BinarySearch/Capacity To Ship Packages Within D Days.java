/*

Capacity To Ship Packages Within D Days

1. A conveyor belt has packages that must be shipped from one port to another within D days.
2. The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
3. Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

 */


import java.util.*;
import java.io.*;

public class Main {

  public static int shipWithinDays(int[]arr, int days) {
    int sum = 0;
    int max = 0;

    for(int i = 0; i < arr.length; i++)
    {
      sum += arr[i];
      max = Math.max(arr[i], max);
    }

    if(arr.length == days)
      return max;

    int lo = max;
    int hi = sum;
    int ans = 0;

    while(lo <= hi)
    {
      int mid = lo + (hi-lo)/2;

      if(isPossible(mid, arr, days))
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

  public static boolean isPossible(int capacity, int[] arr, int days)
  {
    int sd = 1;
    int sum = 0;
    for(int i = 0; i < arr.length; i++)
    {
      sum += arr[i];
      if(sum > capacity)
      {
        sd++;
        sum = arr[i];
      }
    }
    return sd <= days;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(arr, days);
    System.out.println(ans);
  }
}
