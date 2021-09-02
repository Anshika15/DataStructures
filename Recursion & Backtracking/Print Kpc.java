import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        
        ArrayList<String> res = printKPC(str);
        for(String st: res)
            System.out.println(st);

    }
    
    static String codes[] = {".;", "abc", "def", "ghi","jkl", "mno","pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> printKPC(String str) {
        
        if(str.length() == 0)
        {
            ArrayList<String> r = new ArrayList<>();
            r.add("");
            return r;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> resRos = printKPC(ros);
        ArrayList<String> myres = new  ArrayList<String>();
        
        for(char c : codes[ch-'0'].toCharArray())
        {
            for(String st : resRos)
            {
                myres.add(c + st);
            }
        }
        
        return myres;
    }

}
