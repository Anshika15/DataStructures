/*

Random Pick with Blacklist

You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should be equally likely to be returned.

Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.

Implement the Solution class:

Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.

*/


class Solution {
    
    /* logic =>
    
    the inbuilt random function will provide any random value with in a given range so we will use that function to generate random values but to handle the blacklisted values we will use hashmap */
    
    /* we will find the random values from n - number of blacklisted vals */
    
    /* so now in the range (0 , n-num of blacklisted) there will be some values which are blacklisted and in the range (n-blacklisted.length,n) there will be some vals which are not blacklisted */
    
    /* so to handle this case we will use hashmap and map the blacklisted vals in the upper range to non blacklisted vals from lower range */
    /* so when we will call random and it gives us a blacklisted val we will return the corresponding non blacklisted value from lower range */
    

    HashMap<Integer, Integer> map; // mapping the blaclisted with non blacklisted
      Random random;
      int top;
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        top = n - blacklist.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < blacklist.length; i++)
        {
            set.add(blacklist[i]);
        }
        n--;
        for(int i = 0; i < blacklist.length; i++)
        {
            
            if(blacklist[i] < top){
                while(set.contains(n))
                    n--;
            
                map.put(blacklist[i], n); 
                n--;
            }
        }
    }
    
    public int pick() {
        
        int randomIdx = random.nextInt(top);
        
        if(map.containsKey(randomIdx)) // it is blacklisted so instead return the mapped val
        {
            return map.get(randomIdx);
        }
        return randomIdx;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
