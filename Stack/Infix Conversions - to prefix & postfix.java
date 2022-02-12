/* 

Infix Conversions

1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.

*/


import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine(); // a+b

    Stack<String> postfix = new Stack<>(); // ab+
    Stack<String> prefix = new Stack<>(); // +ab

    /*

    ================rules============ 
      ( => push
      a,b => push pre, post
      ) => procsss till we find (
      +,-,*,/ => process till size > 0 && you encounter ( && you get a lower precende operand 
    
    */

    Stack<Character> ops = new Stack<>(); // store operators
    for(int i = 0; i < exp.length(); i++)
    {
       char ch = exp.charAt(i);

       if(ch == '(')
       {
          ops.push(ch);
       }
       else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
       {
          // if operand
          postfix.push(ch + "");
          prefix.push(ch + "");
       }
       else if(ch == ')')
       {
          while(ops.peek() != '(')
          {
             char operator = ops.pop();


             String postV2 = postfix.pop();
             String postV1 = postfix.pop();

             String postVal = postV1 + postV2 + operator;
             postfix.push(postVal);

             String preV2 = prefix.pop();
             String preV1 = prefix.pop();

             String preVal = operator + preV1 + preV2;
             prefix.push(preVal);

          }
          ops.pop();
       }
       else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
       {
          while(ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek()))
          {
             char operator = ops.pop();


             String postV2 = postfix.pop();
             String postV1 = postfix.pop();

             String postVal = postV1 + postV2 + operator;
             postfix.push(postVal);

             String preV2 = prefix.pop();
             String preV1 = prefix.pop();

             String preVal = operator + preV1 + preV2;
             prefix.push(preVal);

          }
          ops.push(ch);
       }
    }

    while(ops.size() > 0)
      {
          char operator = ops.pop();

          String postV2 = postfix.pop();
          String postV1 = postfix.pop();

          String postVal = postV1 + postV2 + operator;
          postfix.push(postVal);

          String preV2 = prefix.pop();
          String preV1 = prefix.pop();

          String preVal = operator + preV1 + preV2;
          prefix.push(preVal);

       }

       System.out.println(postfix.pop());
       System.out.println(prefix.pop());

 }

 public static int precedence(char ch)
 {
    if(ch == '+' || ch == '-')
    {
       return 1;
    }
    else if(ch == '*' || ch == '/')
    {
       return 2;
    }
    return 0;
 }
}
