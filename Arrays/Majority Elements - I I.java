import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int count1 = 1;
        int val1 = arr[0];
        
        int count2 = 0;
        int val2 = arr[0];
        
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] == val1)
                count1++;
            else if(arr[i] == val2)
                count2++;
            else{
                if(count1 == 0)
                {
                    val1 = arr[i];
                    count1 = 1;
                }
                else if(count2 == 0)
                {
                    val2 = arr[i];
                    count2 = 1;
                }
                else
                {
                    count1--;
                    count2--;
                }
            }
        }
        
        /* val1 and val2 are potential candidates */
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(isSolution(val1, arr))
        {
            res.add(val1);
        }
        if(val1 != val2 && isSolution(val2, arr))
        {
            res.add(val2);
        }
        
        return res;
    }
    
    public static boolean isSolution(int val, int[] arr)
    {
        int c = 0;
        for(int i : arr)
        {
            if(i == val)
                c++;
        }
        return c > arr.length/3;
    }


    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}
