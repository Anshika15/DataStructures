/* 

Find Transition Point

1. Given a sorted array containing only 0s and 1s, find the transition point.
2. Transition Point is defined as 1's starting point.
3. If there is no transition point, return -1.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static int findTransition(int[]arr) {
    
    // find first starting index of 1 using binary search
    int res = -1;
    int i = 0;
    int j = arr.length-1;

    while(i <= j)
    {
      int mid = i + (j-i)/2;
      if(arr[mid] == 1)
      {
        res = mid;
        j = mid-1;
      }
      else
      {
        i = mid+1;
      }
    }

    return res;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(findTransition(arr));
  }
}
