/*

1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        
        int sameColor = k; // last two fences with same color
        int diffColor = k * (k-1); // last two fences with different color
        int total = sameColor + diffColor;
        
        for(int i = 3; i <= n; i++)
        {
            sameColor = diffColor * 1;
            diffColor = total * (k-1);
            total = sameColor + diffColor;
        }
        
        System.out.println(total);
    }
}
