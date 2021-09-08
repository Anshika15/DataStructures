/*

1. You are given an infix expression.
2. You are required to evaluate and print it's value 
*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> vals = new Stack<>();
    Stack<Character> ops = new Stack<>();
    
    for(char ch : exp.toCharArray())
    {
        if(ch == '(')
        {
            ops.push(ch);
        }
        else if(ch == ')')
        {
            while(ops.peek() != '(')
            {
               char operator = ops.pop();
               int val2 = vals.pop();
               int val1 = vals.pop();
               
               int res = operation(val1, val2, operator);
               vals.push(res);
            }
            ops.pop();
        }
        else if(Character.isDigit(ch))
        {
            vals.push(ch - '0'); // char to int
        }
        else if(ch == '+' || ch == '/' || ch == '-' || ch == '*')
        {
            while(ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek()))
            {
               char operator = ops.pop();
               int val2 = vals.pop();
               int val1 = vals.pop();
               
               int res = operation(val1, val2, operator);
               vals.push(res); 
            }
            
            ops.push(ch);
        }
    }
    
    
    while(ops.size() != 0)
    {
        char operator = ops.pop();
        int val2 = vals.pop();
        int val1 = vals.pop();
        
        int res = operation(val1, val2, operator);
        vals.push(res);
        
    }
    
    System.out.println(vals.peek());
 }
 
 
public static int precedence(char operator)
{
    if(operator == '+')
    {
        return 1;
    }
    else if(operator == '-')
    {
        return 1;
    }
    else if(operator == '*')
    {
        return 2;
    }
    else
    {
        return 2;
    }
}

public static int operation(int v1, int v2, char operator)
{
    if(operator == '+')
    {
        return v1 + v2;
    }
    else if(operator == '-')
    {
        return v1 - v2;
    }
    else if(operator == '*')
    {
        return v1 * v2;
    }
    else
    {
        return v1 / v2;
    }
}

}
