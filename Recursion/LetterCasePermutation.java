class Solution {
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        
        String op = "";
        solve(S, op);
        return list;
        
    }
    
    void solve(String ip, String op)
    {
      //  System.out.println(ip + " new " + op);
        if(ip.length() == 0)
        {
          //  System.out.println(ip.length());
            list.add(op);
            return;
        }
        
        else if(Character.isLetter(ip.charAt(0)))
        {
            String op1 = op, op2 = op;
            op1 += Character.toUpperCase(ip.charAt(0));
            op2 += Character.toLowerCase(ip.charAt(0));
            ip = ip.substring(1, ip.length());
            solve(ip, op1);
            solve(ip, op2);
        }
        
        else if(Character.isDigit(ip.charAt(0)))
        {
            String op1 = op;
            op1 += ip.charAt(0);
            ip = ip.substring(1, ip.length());
            solve(ip, op1);
        }
        
        return;
    }
}
