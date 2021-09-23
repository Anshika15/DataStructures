// import java.util.ArrayDeque;
// import java.util.Queue;
import java.util.*;

public class Main{
    
    static class Pair{
        int index; // at which index we are
        int size; // how many jumps were allowed
        int jumps; // how many jumps we took
        String psf; // path so far
        
        Pair(int index, int size, int jumps, String psf)
        {
            this.index = index;
            this.size = size;
            this.jumps = jumps;
            this.psf = psf;
        }
    }
    public static void Solution(int arr[]){
        // write your code here
        
        Integer[] dp = new Integer[arr.length];
        
        dp[arr.length-1] = 0;
        for(int i = arr.length-2; i >= 0; i--)
        {
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= steps && i+j < arr.length; j++)
            {
                if(dp[i+j] != null && dp[i+j] < min)
                    min = dp[i+j];
            }
            
            if(min != Integer.MAX_VALUE)
                dp[i] = min+1;
        }
        
        System.out.println(dp[0]);
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(0, arr[0], dp[0], 0 + ""));
        
        while(q.size() > 0)
        {
            Pair rem = q.removeFirst();
            
            if(rem.jumps == 0)
            System.out.println(rem.psf + " .");
            
            for(int j = 1; j <= rem.size && rem.index + j < arr.length; j++)
            {
                int currIndex = rem.index + j;
                if(dp[currIndex] != null && dp[currIndex] == rem.jumps - 1)
                {
                    q.add(new Pair(currIndex, arr[currIndex], dp[currIndex], rem.psf + " -> " + currIndex));
                }
            }
        }
        
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
