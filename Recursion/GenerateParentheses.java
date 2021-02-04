class Solution {
    public List<String> generateParenthesis(int n) {
        
        ArrayList<String> list = new ArrayList<String>();
        
        int close = n;
        int open = n;
        String op = "";
        
        solve(open, close, op, list); 
        return list;
    }
    
    void solve(int open, int close, String op, ArrayList<String> list)
    {
        if(open == 0 && close == 0)
        {
            list.add(op);
            return;
        }
        if(open != 0)
        {
            String op1 = op;
            op1 += "(";
            solve(open - 1, close, op1, list);
        }
        if(close > open)
        {
            String op2 = op;
            op2 += ")";
            solve(open, close-1, op2, list);
        }
    }
}
