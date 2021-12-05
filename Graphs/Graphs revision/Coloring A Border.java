/*
You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

You should color the border of the connected component that contains the square grid[row][col] with color.

Return the final grid.
*/
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        
        return grid;
    }
    
    int[][] dirs = new int[][]{ {1,0}, {-1, 0}, {0,1}, {0,-1} };
    public void dfs(int[][] grid, int r, int c, int clr)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || Math.abs(grid[r][c]) != clr)
            return;

        grid[r][c] = -clr;
        int count = 0;
        
        for(int i = 0; i < 4; i++)
        {
            int rowdash = dirs[i][0] + r;
            int coldash = dirs[i][1] + c;
            
            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || Math.abs(grid[rowdash][coldash]) != clr)
                continue;
            
            count++;
            
            if(grid[rowdash][coldash] == clr)
            {
                dfs(grid, rowdash, coldash, clr);
            }
            
        }
        

        if(count == 4)
        {
            grid[r][c] = clr;
        }
        
    }
}
