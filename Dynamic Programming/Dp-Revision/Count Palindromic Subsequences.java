/* 

Count Palindromic Subsequences

1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.

*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // C(c1Mc2) ==> if c1 == c2 =>C(c1m) + C(mC2) + 1 else C(C1m) + C(mc2) - C(m)

        Scanner s = new Scanner(System.in);

        String str = s.nextLine();

        int dp[][] = new int[str.length()][str.length()];

        for(int g = 0; g < str.length(); g++)
        {
            for(int i = 0, j = g; j < str.length(); j++, i++)
            {
                if(g == 0)
                {
                    dp[i][j] = 1;
                }
                else if(g == 1)
                {
                    if(str.charAt(i) == str.charAt(j))
                        dp[i][j] = 3;
                    else
                        dp[i][j] = 2;
                }
                else{
                    if(str.charAt(i) == str.charAt(j))
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;
                    else
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                }
            }
        }

        System.out.println(dp[0][str.length()-1]);

    }

}
