/* 

Count Possible Triangles


Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 

*/

import java.util.*;
import java.io.*;

public class Main {

  public static int countTriangles(int[]arr) {
    // for a triangle sum of any two side should be greater than third one;
    // to save more comparisons we will first sort the array;
    // keep two pointers one on left, one high & one on high-1
    // if we get a+b < c then all the elements between low and high -1 will also contribute in triangles

    Arrays.sort(arr);
    int count = 0;

    for(int i = arr.length-1; i >= 2; i--)
    {
      int l = 0;
      int r = i-1;

      while(l < r)
      {
        if(arr[l] + arr[r] > arr[i]){
          count += (r-l);
          r--;
        }
        else
        {
          l++;
        }

      }
    }

    return count;

  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countTriangles(arr));
  }
}
