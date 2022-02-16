/*

Counting Elements In Two Arrays

Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

 */

import java.util.*;
import java.io.*;

public class Main {

  public static int[] find(int[]arr1, int[]arr2) {
    
    /* 
    
    first create a frequence array from array and then find the prefix sum from array

    the number present at prefixsum[arr1[i]] would be equal to number of elements less than or equal to arr1[i]

    the size of freq array and prefix sum would be equal to max value in arr1 & arr2
    
    */

    int max = 0;

    for(int i = 0; i < arr1.length; i++)
    {
      max = Math.max(max, arr1[i]);
    }

    for(int i = 0; i < arr2.length; i++)
    {
      max = Math.max(max, arr2[i]);
    }

    int freqArr[] = new int[max+1];

    for(int i = 0; i < arr2.length; i++)
    {
      freqArr[arr2[i]]++;
    }

    int[] prefixSum = new int[max+1];
    int sum = 0;
    for(int i = 0; i < max+1; i++)
    {
      sum += freqArr[i];
      prefixSum[i] = sum;
    }

    int[] res = new int[arr1.length];
    for(int i = 0; i < arr1.length; i++)
    {
      res[i] = prefixSum[arr1[i]];
    }

    return res;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[]a = new int[n1];

    for (int i = 0; i < n1; i++) {
      a[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[]b = new int[n2];

    for (int i = 0; i < n2; i++) {
      b[i] = scn.nextInt();
    }

    int[]ans = find(a, b);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}
