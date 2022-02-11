/*

Max Product Of Three Numbers


1. Given an integer array 'arr',
2. Find three numbers whose product is maximum and return the maximum product.

*/

import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
        // write your code here
          /* find min1, min2, max1, max2, max3*/
        
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;
        
        for(int i = 0; i < arr.length; i++)
        {
            int val = arr[i];
            if(val >= max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = val;
            }
            else if(val >= max2)
            {
                max3 = max2;
                max2 = val;
            }
            else if(val >= max3)
            {
                max3 = val;
            }
            
            if(min1 >= val)
            {
                min2 = min1;
                min1 = val;
            }
            else if(min2 >= val)
            {
                min2 = val;
            }
            
        }
        
        int r1 = min1*min2*max1;
        int r2 = max1*max2*max3;
        return Math.max(r1,r2 );
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}
