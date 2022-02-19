/* 

Matrix Cells In Distance Order

1. You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
2. Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance.

*/

import java.util.*;
import java.io.*;

public class Main {

  public static int[][] solve(int rows, int cols, int rCenter, int cCenter) {
    
    int[][] res = new int[rows*cols][2];

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < cols; j++)
      {
        int idx = i*cols + j;
        res[idx][0] = i;
        res[idx][1] = j;
      }
    }

    Arrays.sort(res, (a,b) -> {
      int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
      int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

      return d1-d2;
    });

    return res;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int rows = scn.nextInt();
    int cols = scn.nextInt();
    int rCenter = scn.nextInt();
    int cCenter = scn.nextInt();

    int[][]ans = solve(rows, cols, rCenter, cCenter);

    for (int i = 0; i < ans.length; i++) {
      System.out.print("(" + ans[i][0] + ", " + ans[i][1] + "), ");
    }
    System.out.println();
  }
}
