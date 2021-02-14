class Solution {
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
