/*
Smallest Number Following Pattern

1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that 
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543


*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // logic

    /* 
    
    if you get d push the number and increse the number
    if you get i push the num, increase the num && pop all vals from stack and print
    
    */

    Stack<Integer> st = new Stack<>();

    int val = 1;

    for(int i = 0; i < str.length(); i++)
    {
        char ch = str.charAt(i);
        if(ch == 'd')
        {
            st.push(val);
            val++;
        }
        else if(ch == 'i')
        {
            st.push(val);
            val++;
            while(st.size() > 0)
            {
                System.out.print(st.pop());
            }
        }
    }
    st.push(val);
    while(st.size() > 0)
    {
        System.out.print(st.pop());
    }
 }
}
