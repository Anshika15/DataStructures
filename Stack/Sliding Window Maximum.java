/*

Sliding Window Maximum

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]


*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    int nge[] = new int[n];
    Stack<Integer> st = new Stack<>();
    st.push(n-1);
    nge[n-1] = n;
    
    for(int i = n-2; i >= 0; i--)
    {
        while(st.size() > 0 && a[i] >= a[st.peek()])
        {
            st.pop();
        }
        
        if(st.size() == 0)
            nge[i] = n;
        else nge[i] = st.peek();
        
        st.push(i);
    }
    
    int j = 0;
    
    for(int i = 0; i <= n-k; i++)
    {
        if(j < i)
        {
            j = i;
        }
        while(nge[j] < i+k)
            j = nge[j];
        System.out.println(a[j]);
    }
    
 }
}
