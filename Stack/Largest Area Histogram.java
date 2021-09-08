/*

Largest Area Histogram

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12

*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code
    
    /* find index for left smaller element and right smaller element */
    /* width = (right smaller element - left smaller element - 1) * arr[i] */  
    Stack<Integer> st = new Stack<>();
    
    int left[] = new int[n];
    st.push(0);
    left[0] = -1;
    
    for(int i = 1; i < n; i++)
    {
        while(st.size() > 0 && arr[st.peek()] >= arr[i])
        {
            st.pop();
        }
        if(st.size() == 0)
        {
            left[i] = -1;
        }
        else
        {
            left[i] = st.peek();
        }
        st.push(i);
    }
    
   /* for(int i = 0; i < n; i++){
       System.out.println(left[i]);
    } */
   
    int[] right = new int[n];
    st = new Stack<>();
    st.push(n-1);
    right[n-1] = n;
    
    for(int i = n-2; i >= 0; i--)
    {
        while(st.size() > 0 && arr[st.peek()] >= arr[i])
        {
            st.pop();
        }
        if(st.size() == 0)
        {
            right[i] = n;
        }
        else
        {
            right[i] = st.peek();
        }
        st.push(i);
    }
    
    /* for(int i = 0; i < n; i++){
       System.out.println(right[i]);
    } */
    
    int res[] = new int[n];
    int max = Integer.MIN_VALUE;
    
    for(int i = 0; i < n; i++)
    {
       res[i] = (right[i] - left[i] - 1)* arr[i];
       max = Math.max(res[i], max); 
    }
    System.out.println(max);
 }
}
