/* 

Heaters

1. Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
2. Every house can be warmed, as long as the house is within the heater's warm radius range. 
3. Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
4. Notice that all the heaters follow your radius standard, and the warm radius will the same.

*/

import java.util.*;
import java.io.*;

public class Main {
  public static int findRadius(int[]houses, int[]heaters) {
    
    /* 
    
    first sort the heater array and then traverse the houses array and find the max(ceil, floor)
    from the heater array for houses[i] using binary search

    */

    Arrays.sort(heaters);
    int res = 0;

    for(int i = 0; i < houses.length; i++)
    {
      Pair p = binarySearch(heaters, houses[i]);

      int d1 = (p.floor == -1) ? Integer.MAX_VALUE : houses[i] - p.floor;
      int d2 = (p.ceil == -1) ? Integer.MAX_VALUE : p.ceil - houses[i];


      int minD = Math.min(d1, d2); // we will select the heater closer to me therefore take min
      res = Math.max(minD, res); // now the result of radius would be max of all the distances
    }
  
    return res;
  }

  public static Pair binarySearch(int[] arr, int val)
  {
    int i = 0;
    int j = arr.length-1;

    Pair p = new Pair();
    while(i <= j)
    {
      int mid = i + (j-i)/2;

      if(arr[mid] == val)
      {
        p.floor = arr[mid];
        p.ceil = arr[mid];
        return p;
      }
      else if(arr[mid] > val)
      {
        p.ceil = arr[mid];
        j = mid-1;
      }
      else{
        p.floor = arr[mid];
        i = mid+1;
      }
    }
    return p;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]houses = new int[n];

    for (int i = 0; i < n; i++) {
      houses[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[]heaters = new int[m];

    for (int i = 0; i < m; i++) {
      heaters[i] = scn.nextInt();
    }

    System.out.println(findRadius(houses, heaters));
  }

  static class Pair{
    int floor = -1;
    int ceil = -1;

    Pair(){}
    Pair(int floor, int ceil)
    {
      this.floor = floor;
      this.ceil = ceil;
    }
  }
}
