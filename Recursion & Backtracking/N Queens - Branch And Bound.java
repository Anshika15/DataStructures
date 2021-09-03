import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    
    boolean[] cols = new boolean[n];
    boolean[] fdiagonal = new boolean[2*n - 1];
    boolean[] bdiagonal = new boolean[2*n - 1];
    
    nQueen(board, n, 0, "", cols, fdiagonal, bdiagonal);
    
  }

    public static void nQueen(boolean[][] board, int n, int row, String asf, boolean[] cols, boolean[] fdiagonal, boolean[] bdiagonal )
    {
        if(row == n)
        {
            System.out.println(asf + ".");
            return;
        }
        for(int col = 0; col < n; col++)
        {
            if(!cols[col] && !fdiagonal[row+col] && !bdiagonal[row - col + n -1])
            {
                board[row][col] = true;
                cols[col] = true;
                fdiagonal[row+col] = true;
                bdiagonal[row - col + n - 1] = true;
                nQueen(board, n, row+1, asf + row + "-" + col + ", ", cols, fdiagonal, bdiagonal);
                cols[col] = false;
                fdiagonal[row+col] = false;
                bdiagonal[row - col + n - 1] = false;
                board[row][col] = false;
            }
            
        }
    }
}
