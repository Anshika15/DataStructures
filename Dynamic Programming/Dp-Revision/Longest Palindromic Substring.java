import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        String str = s.nextLine();
        
        int res = 0;
        
        boolean dp[][] = new boolean[str.length()][str.length()];
        for(int g = 0; g < dp.length; g++)
        {
            for(int i = 0, j = g; j < dp.length; j++, i++)
            {
                if(g == 0)
                {
                    dp[i][j] = true;
                }
                else if(g == 1)
                {
                    if(str.charAt(i) == str.charAt(j))
                    {
                        dp[i][j] = true;
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
                else
                {
                    if(str.charAt(i) != str.charAt(j))
                    {
                        dp[i][j] = false;
                    }
                    else
                    {
                        if(dp[i+1][j-1] == true){
                            dp[i][j] = true;
                        }
                    }
                }
                
                if(dp[i][j] == true)
                {
                    res = g+1;
                }
            }
            
            
        }
        
        System.out.println(res);

    }

}
