import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception 
    {
        
        Scanner s = new Scanner(System.in);
        
        String str = s.next();
        
        int a = 0; // count of subsequences following the pattern a+
        int ab = 0; // count of subsequences following the pattern a+b+
        int abc = 0; // count of subsequences following the pattern a+b+c+
        
        for(char ch : str.toCharArray())
        {
           if(ch == 'a')
           {
               a = 2*a + 1;
           }
           else if(ch == 'b')
           {
               ab = 2*ab + a;
           }
           else if(ch == 'c')
           {
               abc = 2*abc + ab;
           }
        }
        
        System.out.println(abc);

    }
}
