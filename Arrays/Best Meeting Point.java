import java.util.*;

public class Main {
    
    /*
    1. A group of two or more people wants to meet and minimize the total          travel distance.
    2. You are given a 2D grid of values 0 or 1, where each 1 marks the home      of someone in the group. 
    3. Return min distance where distance is calculated using 'Manhattan           Distance', where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
    
    */

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        
        /* best meeting point would be (median of x coordinates, median of y) */
        
        /* distance = Math.abs(medianx - x1) + Math.abs(medianx - x2)... + Math.abs(mediany - y1) + Math.abs(mediany - y2).. */
        
        /* approach -1 to find median */
        /* 
           1) get all x coordinates
           2) get all y coordinates
           3) sort both array
           4) select mid point as median
        */
        
        /* optimal approach to get x-coordinate and y-coordinate in sorted */
        /* for x - coordinate traverse row wise*/
        /* for y - coordinate traverse col-wise*/
        
        
        /* steps to follow -> 
           1) get all x coordinates in row wise order(to get sorted)
           2) get all y coordinates in col wise (to get sorted)
           3) select mid point as median
           4) calculate distance
           5) return ans
        */
        
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        
        /* first step */
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)
                    x.add(i);
        }
        
        /* second step */
        for(int j = 0; j < grid[0].length; j++)
        {
            for(int i = 0; i < grid.length; i++)
                if(grid[i][j] == 1)
                    y.add(j);
        }
        
        /* third step */
        int xmedian = x.get(x.size()/2);
        int ymedian = y.get(y.size()/2);
        
        /* 4th step */
        int dist = 0;
        
        for(int xval: x)
        {
            dist += Math.abs(xval - xmedian);
        }
        
        for(int yval: y)
        {
            dist += Math.abs(yval - ymedian);
        }
        
        /* 5th step */
        return dist;
        
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}
