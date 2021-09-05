import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    
    int arr[] = new int[n];
    for(int i = 0; i < n; i++)
    {
        arr[i] = s.nextInt();
    }
    
    HashMap<Integer, Boolean> map = new HashMap<>();
    for(int i = 0; i < n; i++)
    {
        map.put(arr[i], true);
    }
    
    for(int i = 0; i < n; i++)
    {
        if(map.containsKey(arr[i] - 1)){
        map.put(arr[i], false);
        }
    }
    
    int maxStart = 0;
    int maxLen = 0;
    
    for(int val : arr)
    {
        if(map.get(val) == true){
            int tempLen = 1;
            int tempStart = val;
            while(map.containsKey(tempStart + tempLen))
            {
                tempLen++;
            }
            
            if(tempLen > maxLen)
            {
                maxLen = tempLen;
                maxStart = tempStart;
            }
        }
    }
    
    for(int ti = 0; ti < maxLen; ti++)
    {
        System.out.println(maxStart + ti);
    }
    
 }

}
