import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner s = new Scanner(System.in);
    long n = s.nextInt();
    
    long oB =  1; // plot ending with building
    long oS = 1; // plot ending with space

    for(int i = 2; i <= n; i++)
    {
        long nb = oS;
        long ns = oB + oS;
        oB = nb;
        oS = ns;
    }
    
    long val = oB + oS;
    System.out.println(val * val);
 }

}
