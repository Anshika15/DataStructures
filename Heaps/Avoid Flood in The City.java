/*

Avoid Flood in The City

Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake which is full of water, there will be a flood. Your goal is to avoid the flood in any lake.

Given an integer array rains where:

rains[i] > 0 means there will be rains over the rains[i] lake.
rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
Return an array ans where:

ans.length == rains.length
ans[i] == -1 if rains[i] > 0.
ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.

Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes. 

*/

class Solution {
     public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> rainMap = new HashMap<>(); // store the rain lake and index
        
        /* in set we will store the dry days */
        TreeSet<Integer> set = new TreeSet<>(); // dry day index
        int n = rains.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            int x = rains[i];
            if(x == 0)
            {
                set.add(i); // dry day
                ans[i] = 1; // keep any default value
            }
            else // if rain occurs we have to store the -1 in ans
                /* but here are two cases whether there will be flood or not */
                /* if we try to rain on filled lake there will be flood else if lake is empty there are chances of no flood further */
            {
                Integer id = rainMap.get(x); // check if rain at lake x has occured before or not
                if(id == null) // first time occuring
                {
                  rainMap.put(x, i);  // no flood
                }
                else // check flood
                {
                    /* The higher() is a method of TreeSet class. This method returns the smallest element in the set which is greater than the element in the argument, else it will return null if the element is not present. */
                    
                    Integer dryId = set.higher(id); // we check if there is after some time any dry day
                    if(dryId == null)
                    {
                        // can't stop flood
                        return new int[0]; // if no dry day found further return empty array
                    }
                    ans[dryId] = x; // else on this dry day we will be empty our lake and prevent flood
                    set.remove(dryId); // as dryday is used remove it from set
                    rainMap.put(x, i);
                    
                }
                ans[i] = -1;
            }
        }
        
        return ans;
     }
}
