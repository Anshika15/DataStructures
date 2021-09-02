import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean vis[][] = new boolean[n][m];
        floodfill(arr, 0, 0, "", vis);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int row, int col, String asf, boolean[][] vis) {
        
        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1 || vis[row][col] == true)
            return;
            
        if(row == maze.length - 1 && col == maze[0].length - 1)
        {
            System.out.println(asf);
            return;
        }
            
        vis[row][col] = true;
       // System.out.println(row + " " + col);
        floodfill(maze, row-1, col, asf + "t" , vis);
        floodfill(maze, row, col-1, asf + "l" , vis);
        floodfill(maze, row+1, col, asf + "d" , vis);
        floodfill(maze, row, col+1, asf + "r" , vis);
        vis[row][col] = false;
    
    }
}
