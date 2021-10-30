import java.util.*;

/*
1. You are given an n x n 2D matrix representing an image.
2. rotate the image by 90 degrees (clockwise).
3. You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
4. DO NOT allocate another 2D matrix and do the rotation.
*/

public class Main {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static void rotate(int[][] matrix) {
    // write your code here
    
    // transpose
    transpose(matrix);
    
    // reverse each row
    reverse(matrix);
  }
  
  public static void transpose(int[][] matrix)
  {
      for(int i = 0; i < matrix.length; i++)
      {
          for(int j = 0; j < i; j++)
          {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp; 
          }
      }
  }
  
  public static void reverse(int[][] matrix)
  {
      for(int i = 0; i < matrix.length; i++)
      {
          int left = 0;
          int right = matrix[i].length - 1;
          while(left < right)
          {
              int temp = matrix[i][left];
              matrix[i][left] = matrix[i][right];
              matrix[i][right] = temp;
              left++;
              right--;
          }
      }
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }
    rotate(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
