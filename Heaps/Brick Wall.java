/*

Brick Wall

There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.

Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.

*/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        /* minimise the brick crossing == maximising the split crossing */
        
        /* coordinate - split count */
        /* coordinate == prefix sum in a row */
        /* we will not go till last index in a row as we have to split in between not at end */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < wall.size(); i++)
        {
            int prefsum = 0;
            for(int j = 0; j < wall.get(i).size() - 1; j++)
            {
                prefsum += wall.get(i).get(j);
                map.put(prefsum, map.getOrDefault(prefsum, 0)+1);
                max = Math.max(max, map.get(prefsum));
            }
        }
        
        return wall.size() - max;
        
        
        /* ans == min brick crosisng == total - max brick spliting */
        
    }
}
