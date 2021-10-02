import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        
        ArrayList<Integer> res = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>(); // element, freq
        
        for(int element :  arr)
        {
            if(map.containsKey(element))
            {
                map.put(element, map.get(element)+1);
            }
            else
            {
                map.put(element, 1);
            }
        }
        
        for(int element : map.keySet())
        {
            if(map.get(element) > arr.length/k)
                res.add(element);
        }
        return res;
    }
    
    //~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}
