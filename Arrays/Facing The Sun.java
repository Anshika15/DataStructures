/* 

Facing The Sun

Given an array ht representing heights of buildings. You have to count the buildings which will see the sunrise (Assume : Sun rise on the side of array starting point).

*/

import java.util.*;
import java.io.*;

public class Main {
  public static int countBuildings(int[]ht) {
    // keep finding left max if lmax < ht[i] then increase count;

    int count = 0;

    int lmax = Integer.MIN_VALUE;
    for(int val : ht)
    {
      if(lmax < val)
      {
        count++;
      }
      lmax = Math.max(lmax, val);
    }

    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]ht = new int[n];

    for (int i = 0; i < n; i++) {
      ht[i] = scn.nextInt();
    }

    System.out.println(countBuildings(ht));
  }
}
