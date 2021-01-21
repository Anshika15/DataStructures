class SequencePatternMatching {
    public boolean isSubsequence(String s, String t) {
        
        int res = lcs(s, t);
       /* System.out.println(res);
        System.out.println(s.length());*/
        if(res == s.length())
            return true;
        return false;
    }
    
    public int lcs(String s1, String s2)
    {
        int[][] t = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = 0; i <= s1.length(); i++)
        {
            for(int j = 0; j <= s2.length(); j++)
            {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        
        for(int i = 1; i <= s1.length(); i++)
        {
            for(int j = 1; j <= s2.length(); j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] =1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[s1.length()][s2.length()];
    }
}
