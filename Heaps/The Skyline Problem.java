/*

The Skyline Problem

A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

lefti is the x coordinate of the left edge of the ith building.
righti is the x coordinate of the right edge of the ith building.
heighti is the height of the ith building.
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]


*/

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        /* in Priority Queue we will store the active heights of rectangle and will create a max heap as in all the active rectangles we will always be creating the skyline using the rectangle with heighest height and that we can get using peek value at heap */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        List<Pair> list = new ArrayList<>();
        
        /* store the starting of rectangle with -ve of height */
        /* store the end of rectangle with +ve of height */
        for(int i = 0; i < buildings.length; i++)
        {
            int start = buildings[i][0];
            int end = buildings[i][1];
            int ht = buildings[i][2];
            list.add(new Pair(start, -ht));
            list.add(new Pair(end, ht));
        }
        
        Collections.sort(list);
        int currht = 0;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++)
        {
            Pair p = list.get(i);
            int x = p.x;
            int ht = p.ht;
            if(ht < 0)
            {
                // start
                pq.add(-ht);
            }
            else
            {
                // end
                pq.remove(ht);
            }
            if(currht != pq.peek())
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(x); // the point at which the change is occuring
                temp.add(pq.peek()); // now this will be the max height of skyline
                    
                ans.add(temp);
                currht = pq.peek();
            }
        }
        
        return ans;
        
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int ht;
        
        Pair(){}
        
        Pair(int x, int ht)
        {
            this.x = x;
            this.ht = ht;
        }
        
        public int compareTo(Pair p)
        {
            if(this.x != p.x)
                return this.x - p.x;
            else
                return this.ht - p.ht; // to remove redundancy
        }
    }
}
