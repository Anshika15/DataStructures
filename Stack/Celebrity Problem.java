/* 
Celebrity Problem

1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"

        Stack<Integer> st = new Stack<>();

        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            st.add(i);
        }

        // using stack eliminate the candidates of being a celebrity  
        // then we will check for the candidate left if it is a celebrity 
        // than return it else no one is celebrity 

        while(st.size() >= 2)
        {
            int v1 = st.pop();
            int v2 = st.pop();

            if(arr[v1][v2] == 1)
            {
                // if v1 knows v2 ==> v1 is not a celebrity
                st.push(v2);
            }
            else{
                st.push(v1);
            }
        }

        int potentialCandidate = st.pop();

        for(int i = 0; i < arr.length; i++)
        {
            if(i != potentialCandidate)
            {
                if(arr[i][potentialCandidate] == 0 || arr[potentialCandidate][i] == 1)
                {
                    // if i dont know potenital candiadate then he cant be a celebrity
                    // if potential candidate knows someone then he is not a velebrity
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potentialCandidate);
    }

}
