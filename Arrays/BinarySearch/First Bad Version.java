/* 
First Bad Version

1. You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
2. Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
3. You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static int firstBadVersion(int n) {
    //apply binary search and find first bad index
    int res = -1;
    int i = 1; int j = n;

    while(i <= j)
    {
      int mid = i + (j-i)/2;
      if(isBadVersion(mid))
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

  static int bad = 0;
  public static boolean isBadVersion(int val) {
    if (val >= bad) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void solve(int n, int fbv) {
    bad = fbv;
    System.out.println(firstBadVersion(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int fbv = scn.nextInt();

    solve(n, fbv);
  }
}
