import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        
        int overAllMax = Integer.MIN_VALUE;
        int dp[] = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            Integer max = null;
            for(int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i])
                {
                    if(max == null)
                        max = dp[j];
                    
                    max = Math.max(dp[j], max);
                }
            }
            
            if(max == null)
            {
                dp[i] = arr[i];
            }
            else
            {
                dp[i] = max + arr[i];
            }
            
            overAllMax = Math.max(dp[i], overAllMax);
        }
        
        System.out.println(overAllMax);
    }

}
