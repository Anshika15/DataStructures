import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        long dp[] = new long[str.length()+1];
        dp[0] = 1;
        
        HashMap<Character, Integer> lo = new HashMap<>(); // last occurence
        
        for(int i = 1; i < dp.length; i++)
        {
            dp[i] = 2*dp[i-1];
            
            char ch = str.charAt(i-1);
            if(lo.containsKey(ch))
            {
               int idx = lo. get(ch);
               dp[i] = dp[i] - dp[idx-1];
            }
            lo.put(ch, i); // save the last occurence of element(we are saving index of dp)
        }

        System.out.println(dp[str.length()] - 1); // as we have to print non-empty subseq therefore -1 as empty string always have 1 subseq
    }
}
