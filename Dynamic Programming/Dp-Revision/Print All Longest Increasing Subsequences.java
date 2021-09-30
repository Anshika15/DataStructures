import java.util.*;

public class Main{
    
    public static class Pair {
        int l; //length
        int i; // index
        int v; // value
        String psf; // path so far
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
        // write your code here
        
        int dp[] = new int[arr.length];
        dp[0] = 1;
        int res = 0;
        
        for(int i = 0; i < dp.length; i++)
        {
            int max = 0;
            
            for(int j = 0; j < i; j++)
            {
                if(arr[i] >= arr[j])
                {
                    if(dp[j] > max)
                        max = dp[j];
                }
            }
            
            dp[i] = max+1;
            if(res < dp[i])
            {
                res = dp[i];
               
            }
        }
        
        System.out.println(res);
        
        LinkedList<Pair> q = new LinkedList<>();
        for(int index = 0; index < dp.length; index++)
        {
            if(dp[index] == res)
            q.add(new Pair(res, index, arr[index], arr[index] + ""));
        }
        
        while(q.size() > 0)
        {
           // System.out.println(q);
            Pair rem = q.removeFirst();
            
            if(rem.l == 1)
                System.out.println(rem.psf);
            
            for(int j = rem.i-1; j >= 0; j--)
            {
                if(dp[j] == rem.l - 1 && arr[j] <= rem.v)
                {
                    q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
        
        
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
