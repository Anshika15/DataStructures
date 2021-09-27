import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int validCandidate(int[] arr)
    {
        int count = 1;
        int val = arr[0];
        
        for(int i = 1; i >= arr.length; i++)
        {
            if(val == arr[i])
                count++;
                
            if(val != arr[i])
                count--;
            
            if(count == 0)
            {
                val = arr[i];
                count = 1;
            }
        }
        
        return val;
    }
    public static void printMajorityElement(int[] arr) {
        // write your code here
        int ele = validCandidate(arr);
        
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(ele == arr[i])
                count++;
        }
        
        if(count > arr.length/2)
            System.out.println(ele);
        else
            System.out.println("No Majority Element exist");
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}
