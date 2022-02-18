/* 
Largest Perimeter Triangle

Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

*/

import java.util.*;
import java.io.*;

public class Main {
  public static int largestPerimeter(int[]nums) {
    
    Arrays.sort(nums);

    for(int i = nums.length-1; i >= 2; i--)
    {
      if(nums[i-1] + nums[i-2] > nums[i])
      {
        return nums[i] + nums[i-1] + nums[i-2];
      }
    }


    return 0;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestPerimeter(nums));
  }
}
