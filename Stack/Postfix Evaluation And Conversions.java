/* 

Postfix Evaluation And Conversions

1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // infix = (a+b), postfix = ab+, prefix = +ab

    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    Stack<Integer> valStack = new Stack<>();

    for(int i = 0; i < exp.length(); i++)
    {
        char ch = exp.charAt(i);

        if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
        {
            int val2 = valStack.pop();
            int val1 = valStack.pop();
            int val = operation(val1, val2, ch);
            valStack.push(val);

            String infixval2 = infix.pop();
            String infixval1 = infix.pop();
            String infixval = "(" + infixval1 + ch + infixval2 + ")";
            infix.push(infixval);

            String prefixval2 = prefix.pop();
            String prefixval1 = prefix.pop();
            String prefixval = ch + prefixval1 + prefixval2;
            prefix.push(prefixval);
        }
        else{
            valStack.push(ch - '0');
            infix.push(ch + "");
            prefix.push(ch + "");
        }
    }

    System.out.println(valStack.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());

 }

 public static int operation(int val1, int val2, char ch)
 {
     if(ch == '+')
     {
         return val1 + val2;
     }
     else if(ch == '-')
     {
         return val1 - val2;
     }
     else if(ch == '/')
     {
         return val1 / val2;
     }
     else if(ch == '*')
     {
         return val1 * val2;
     }
     return -1;
 }
}
