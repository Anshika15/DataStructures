import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }
        
        int incl = arr[0];
        int excl = 0;
        
        for(int i = 1; i  < n; i++)
        {
            int nincl = excl + arr[i];
            int nexcl = Math.max(incl, excl);
            excl = nexcl;
            incl = nincl;
        }
        
        System.out.println(Math.max(incl, excl));

    }
}
