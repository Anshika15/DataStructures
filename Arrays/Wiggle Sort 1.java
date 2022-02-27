/*

Wiggle Sort 1
1. Given an integer array 'arr'.
2. Reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

*/

import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static void wiggleSort(int[] arr) {
    /* method1 (time complexity => O(nlogn); space complexity => o(n))

    sort the array

    take new array keep two pointers i & j

    lets say array is 1 2 3 4 5 (i is at idx = 0 & j is at arr.length-1)

    new array => 1 5 2 4 3 (put i in first idx then i++, put j at second idx then j-- & so on..)

    */


    /* 
    
      method2 O(n) time & O(1) space

      if(idx is even)
      {
        if(arr[idx+1] < arr[idx])
          swap(idx, idx+1)
      }
      if(idx is odd)
      {
        if(arr[idx+1] > arr[idx])
          swap(idx, idx+1)
      }
    */

    for(int i = 0; i < arr.length - 1; i++)
    {
      if(i%2 == 0)
      {
        if(arr[i+1] < arr[i])
          swap(arr, i, i+1);
      }
      else
      {
        if(arr[i+1] > arr[i])
          swap(arr, i, i+1);
      }
    }

  }

  static void swap(int[] arr, int idx1, int idx2)
  {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    wiggleSort(arr);

    for (int val : arr) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

}
