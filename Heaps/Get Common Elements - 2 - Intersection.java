import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    
    int n1 = s.nextInt();
    int arr1[] = new int[n1];
    for(int i = 0; i < n1; i++)
        arr1[i] = s.nextInt();
        
    int n2 = s.nextInt();
    int arr2[] = new int[n2];
    for(int i = 0; i < n2; i++)
        arr2[i] = s.nextInt();
        
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for(int i : arr1)
    {
        if(map.containsKey(i))
        {
            map.put(i, map.get(i) + 1);
        }
        else
        {
            map.put(i, 1);
        }
    }
    
    for(int i : arr2)
    {
        if(map.containsKey(i)){
            if(map.get(i) > 0){
            System.out.println(i);
            map.put(i, map.get(i) - 1);
            }
        }
    }
 }

}
