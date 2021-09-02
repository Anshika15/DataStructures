import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        printEncodings(str, "");

    }

    public static void printEncodings(String str, String psf) {
        
        if(str.length() == 0){
            System.out.println(psf);
            return;
        }
        else if(str.length() == 1){
            if(str.charAt(0) == '0')
            {
                return;
            }
            else
            {
                int ch = str.charAt(0) - '0';
                char code = (char)(ch + 'a' -1);
                //psf += code;
                System.out.println(psf+code);
            }
        }
        else{
            char ch = str.charAt(0);
            String st1 = str.substring(1);
            if(ch == '0')
            {
                return;
            }
            else
            {
                int chv = ch - '0';
                char code = (char)(chv + 'a' -1);
                printEncodings(st1, psf+code);
            }
            
            String st2 = str.substring(0,2);
            String ros = str.substring(2);
            
            int ch12 = Integer.parseInt(st2);
            if(ch12 <= 26)
            {
                char code = (char)(ch12 + 'a' - 1);
                printEncodings(ros, psf+code);
            }
            
        }
        
    }

}
