/*

Balanced Brackets

1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        String str = s.nextLine();
        Stack<Character> st = new Stack<>();
        
        for(char ch : str.toCharArray())
        {
            if(ch == '[' || ch == '{' || ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ']')
            {
               if(st.size() > 0 && st.peek() == '[')
               {
                   st.pop();
                   
               }
               else
               {
                   System.out.println(false);
                   return;
               }
            }
            else if(ch == '}')
            {
                if(st.size() > 0 && st.peek() == '{')
               {
                   st.pop();
                   
               }
               else
               {
                   System.out.println(false);
                   return;
               }
            }
            else if(ch == ')')
            {
               if(st.size() > 0 && st.peek() == '(')
               {
                   st.pop();
                   
               }
               else
               {
                   System.out.println(false);
                   return;
               } 
            }
        }
        
        if(st.size() > 0)
            System.out.println(false);
        else System.out.println(true);
    }

}
