import java.io.*;
import java.util.*;

public class Main {
  
  private static void optimalbst(int[] keys, int[] frequency, int n) {
    
    int dp[][] = new int[n][n];
    
    for(int g = 0; g < n; g++)
    {
        for(int i = 0, j = g; j < n; i++, j++)
        {
            if(g == 0)
            {
                dp[i][j] = frequency[i];
            }
            else if(g == 1)
            {
                int f1 = frequency[i];
                int f2 = frequency[j];
                dp[i][j] = Math.min(f1 + 2*f2, f2 + 2*f1);
            }
            else 
            {
                int min = Integer.MAX_VALUE;
                int freqSum = 0;
                for(int x = i; x <= j; x++)
                {
                    freqSum += frequency[x];
                }
                for(int k = i; k <= j; k++) // k is root
                {
                    int left = 0; 
                    int right = 0;
                    if(k != i)
                        left = dp[i][k-1];
                    if(k != j)
                        right = dp[k+1][j];
                    
                    min = Math.min(left+right+freqSum, min); 
                }
                dp[i][j] = min;
            }
        }
    }
    
    System.out.println(dp[0][n-1]);
    
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
	int[] keys = new int[n];
	int[] frequency = new int[n];
    for(int i= 0 ;i < n ; i++) {
		keys[i] = scn.nextInt();
	}
	for(int i = 0 ; i < n; i++){
      frequency[i] = scn.nextInt();
    }
	optimalbst(keys,frequency,n);
	}

}
