import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        
        ArrayList<String> ans = printSS(str);
        for(String st: ans)
        System.out.println(st);

    }

    public static ArrayList<String> printSS(String str) {
        
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> res = printSS(ros);
        
        ArrayList<String> myRes = new ArrayList<String>();
        for(String st : res)
        {
            myRes.add(ch + st);
        }
        for(String st : res)
        {
            myRes.add("" + st);
        }
        
        return myRes;
        
    }

}
