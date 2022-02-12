/*

Prefix Evaluation And Conversions

1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

 */

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> valStack = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    for(int i = exp.length()-1; i >= 0; i--)
    {
        char ch = exp.charAt(i);

        if(ch == '+' || ch == '-' || ch == '/' || ch == '*')
        {
            int v1 = valStack.pop();
            int v2 = valStack.pop();
            valStack.push(operation(v1, v2, ch));

            String iv1 = infix.pop();
            String iv2 = infix.pop();
            infix.push("(" + iv1 + ch + iv2 + ")");

            String pv1 = postfix.pop();
            String pv2 = postfix.pop();
            postfix.push(pv1 + pv2 + ch);

        }
        else
        {
            valStack.push(ch - '0');
            infix.push(ch + "");
            postfix.push(ch + "");
        }
    }

    System.out.println(valStack.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());

 }

 public static int operation(int v1, int v2, char ch)
 {
     if(ch == '+')
     {
         return v1+v2;
     }
     else if(ch == '-')
     {
         return v1-v2;
     }
     else if(ch == '/')
     {
         return v1/v2;
     }
     else if(ch == '*')
     {
         return v1*v2;
     }
     return -1;
 }
}
