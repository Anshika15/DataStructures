/*
We can scramble a string s to get a string t using the following algorithm:

If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.

*/

class Solution {
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
        
        if(s1.length() != s2.length())
            return false;
        if(s1.length() == 0 && s2.length() == 0)
            return true;
        return solve(s1, s2);
        
    }
    
    boolean solve(String s1, String s2)
    {
        if(s1.equals(s2))
            return true;
        if(s1.length() <= 1)
            return false;
        
        String key = s1;
        key = key + " ";
        key = key + s2;
        if(map.containsKey(key))
           return map.get(key);
        
        
        int n = s1.length();
        boolean flag = false;
        for(int i = 1; i <= n-1; i++)
        {
            if(case1(s1,s2,i,n) || case2(s1,s2,i,n))
            {
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }
    
    boolean case2(String s1, String s2, int i, int n)
    {
        if(solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i, n),s2.substring(i, n)))
            return true;
        return false;
    }
    
    boolean case1(String s1, String s2, int i, int n)
    {
         if (solve(s1.substring(n - i, n), s2.substring(0, i)) && solve(s1.substring(0, n - i), s2.substring(i, n))) 
            return true;
        return false;
    }
}
