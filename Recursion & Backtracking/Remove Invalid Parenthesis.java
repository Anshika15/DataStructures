/* 

Remove Invalid Parenthesis

1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.

*/

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, int minRemovalAllowed, HashSet<String> ans) {
		/* 
		keep on removing one character from string till the time min removal is finished
		
		*/
		
		if(minRemovalAllowed == 0)
		{
		    if(isValid(str))
		    {
		        if(!ans.contains(str)){
		            System.out.println(str);
		            ans.add(str);
		        }
		    }
		    return;
		}
		
		for(int i = 0; i < str.length(); i++)
		{
		    String left = str.substring(0,i); // ith char is removed
		    String right = str.substring(i+1);
		    
		    solution(left + right, minRemovalAllowed - 1, ans);
		}
	}

    // minimum number of brackets we have to remove to make it valid
	public static int getMin(String str){
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < str.length(); i++)
		{
		    char ch = str.charAt(i);
		    if(ch == '(')
		    {
		        st.push(ch);
		    }
		    else if(ch == ')')
		    {
		        if(st.size() == 0)
		        {
		            st.push(ch);
		        }
		        else if(st.peek() == '(')
		        {
		            st.pop();
		        }
		        else if(st.peek() == ')')
		        {
		            st.push(ch);
		        }
		    }
		}
		return st.size();
	}
	
	// check if the given string is valid or not
	public static boolean isValid(String str)
	{
	    /* 
	    
	    using stack
	    if ( => push
	    if ) => {
	        case1 -> if st.peek() == ( => pop
	        case2 -> if st.size() == 0 => push
	        case3 -> if st.peek() == ) => push
	    }
	    
	    */
	    
	    Stack<Character> st = new Stack<>();
		for(int i = 0; i < str.length(); i++)
		{
		    char ch = str.charAt(i);
		    if(ch == '(')
		    {
		        st.push(ch);
		    }
		    else if(ch == ')')
		    {
		        if(st.size() == 0)
		        {
		            st.push(ch);
		        }
		        else if(st.peek() == '(')
		        {
		            st.pop();
		        }
		        else if(st.peek() == ')')
		        {
		            st.push(ch);
		        }
		    }
		}
		return st.size() == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
	}
		
}
