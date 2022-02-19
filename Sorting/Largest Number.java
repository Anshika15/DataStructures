/*

Largest Number

You are given an array of N positive integers which represent digits of a number.
You have to form the largest number possible after performing an operation exactly once. The operation is -  
Select two indices a and b, and swap their values.
Print the largest number formed. 

*/

import java.util.*;
import java.io.*;

public class Main {

  public static String largestNumber(int[]arr) {
    String[] nums = new String[arr.length];

    for(int i = 0; i < nums.length; i++)
      nums[i] = arr[i] + "";

    Arrays.sort(nums, (a,b) -> {
      // check by which combination we will get larger number and sort it accordingly
      long n1 = Long.parseLong(a+b);
      long n2 = Long.parseLong(b+a); 

      if(n1 > n2)
        return 1;
      else if(n1 < n2)
        return -1;
      else
        return 0;

    });

    StringBuilder sb = new StringBuilder();

    for(int i = nums.length - 1; i >= 0; i--)
      sb.append(nums[i]);
    return sb.toString();
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestNumber(nums));
  }
}
