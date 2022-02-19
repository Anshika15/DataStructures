/*

Leaders In An Array

Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 

 */

import java.util.*;
import java.io.*;

public class Main {

  public static ArrayList<Integer>  leaders(int[]arr) {

    ArrayList<Integer> res = new ArrayList<Integer>();

    int rmax = arr[arr.length-1];

    for(int i = arr.length-1; i >= 0; i--)
    {

      if(rmax <= arr[i])
        res.add(arr[i]);
      rmax = Math.max(rmax, arr[i]);
    }

    Collections.reverse(res);
    return res;

  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = leaders(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}
