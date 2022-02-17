/*

Maximum Number Of 1's Row

Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static int findRow(int[][]mat) {
    
    int max = 0;
    int res = 0;

    for(int i = 0; i < mat.length; i++)
    {
      // find first occurence of 1 in each row and count of 1's == cols - firstOccurenceOf1

      int count = find(mat[i]);

      if(count > max)
      {
        max = count;
        res = i;
      }
    }

    return res;
  }

  public static int find(int[] arr)
  {
    int cols = arr.length;
    int res = cols;

    int i = 0; int j = cols-1;
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

    return cols - res;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][]mat = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(findRow(mat));
  }
}
