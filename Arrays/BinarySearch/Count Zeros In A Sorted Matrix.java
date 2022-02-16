/* 

Count Zeros In A Sorted Matrix

Given a Binary Square Matrix where each row and column of the matrix is sorted in ascending order. Find the total number of Zeros present in the matrix.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static int countZeros(int[][]mat) {
    
    // apply binary search and keep on discarding the part at which side we get 1
    // and as soon as we get 0 then all the values before this will also be equal to zero so add them to count by using colidx+1;

    int n = mat.length;

    int i = 0; // row
    int j = n-1; // col
    int res = 0;

    while(i < n && j >= 0)
    {
      if(mat[i][j] == 0)
      {
        res += j+1;
        i++;
      }
      else
      {
        j--;
      }
    }

    return res;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][]mat = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(countZeros(mat));
  }
}
