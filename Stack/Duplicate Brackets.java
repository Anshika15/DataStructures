/*

Duplicate Brackets

1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless. 
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true

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
            if(ch == ')')
            {
                if(st.peek() == '(')
                {
                    System.out.println(true);
                    return;
                }
                
                while(st.size() > 0 && st.peek() != '(')
                {
                    st.pop();
                }
                st.pop();
            }
            else {
                st.push(ch);
            }
        }
        
        System.out.println(false);
        return;

    }

}
