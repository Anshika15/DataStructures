// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    
    if(i == board.length)
    {
        display(board);
        return;
    }
    
    int ni = 0;
    int nj = 0;
    if(j == board[0].length - 1)
    {
       ni = i+1;
       nj = 0;
    }
    else
    {
       ni = i;
       nj = j+1;
    }
    
    if(board[i][j] != 0)
    {
        solveSudoku(board, ni, nj);
    }
    else
    {
        for(int pos = 1; pos <= 9; pos++)
        {
            if(isValid(board, i, j, pos))
            {
                board[i][j] = pos;
                solveSudoku(board, ni, nj);
                board[i][j] = 0;
            }
        }
    }
    
  }
  
  
  public static boolean isValid(int[][] board, int i, int j, int val)
  {
      /* check each col */
      for(int col = 0; col < board[0].length; col++)
      {
          if(board[i][col] == val)
            return false;
      }
      
      /* check each row */
      for(int row = 0; row < board.length; row++)
      {
          if(board[row][j] == val)
            return false;
      }
      
      /* check each 3*3 matrix it belongs to */
      
      int smi = i / 3 * 3;
      int smj = j / 3 * 3;
      
      for(int row = 0; row < 3; row++)
      {
          for(int col = 0; col < 3; col++)
          {
              if(board[smi + row][smj + col] == val)
                return false;
          }
      }
      
      return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
