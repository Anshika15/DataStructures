import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        
        int lis[] = new int[n]; // longest increasing subsequence ending at i
    
        for(int i = 0; i < n; i++)
        {
            int max = 0;
            for(int j = 0; j < i; j++)
            {
                if(arr[j] <= arr[i])
                {
                    max = Math.max(lis[j], max);
                }
            }
            
            lis[i] = max+1;
        }
        
        int lds[] = new int[n]; // longest decreasing subsequence starting at i
    
        for(int i = n-1; i >= 0; i--)
        {
            int max = 0;
            for(int j = n-1; j > i; j--)
            {
                if(arr[j] <= arr[i])
                {
                    max = Math.max(lds[j], max);
                }
            }
            
            lds[i] = max+1;
        }
        
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            if(lis[i]+lds[i]-1 > res)
            {
                res = lis[i]+lds[i]-1;
            }
        }
        System.out.println(res);
    }

}
