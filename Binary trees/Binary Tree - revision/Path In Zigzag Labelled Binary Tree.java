/* 

 Path In Zigzag Labelled Binary Tree


In an infinite binary tree where every node has two children, the nodes are labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.


Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.


*/

class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        
        /* 
        if we check in our normal tree then we can find ans by keep going on to parent and then reverse the ans
        in this case our parent is n/2
        eg for 10 list = 10,5,2,1
        reverse the list = 1,2,5,10 this is our ans
        
        but in zigzag labelled tree our parent would be complement(n)/2 
        
        end - n = complement node/swapped node - start
        therefore, complement = end + start - n;
        
        end = 2*level - 1
        
        start = level

        ==> complement = 3*level-n-1;
        
        how to find level ====
        eg n = 10;
        1 , 2 , 4 , 8 // number of lemenets in each level i.e for level 1 = 1 element, for level 2 = 2 element, for level 3 = 4 element...
        
        1+2+4+8 == 15 > 10 ==> 10 lies in level 4
        */
        
        int level = 1; // number of elements in level
        
        int currval = 0;
        while(currval < n)
        {
            currval += level;
            level = 2*level;
        }
        
         // if we want to find for n = 10 then after processing of while currval will be equal to 15 and level = 16;
        // now for n = 10 level should be equal to 8
        
        level /= 2;
        
        List<Integer> res = new ArrayList<>();
        
        while(n != 1)
        {
            int complement = 3*level - n - 1;
            res.add(n);
            int parent = complement/2;
            n = parent;
            level = level/2;
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }
}
