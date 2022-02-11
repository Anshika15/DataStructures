/* 


Product Of Array Except Itself Without Using Division Operator

1. Given an integer array of size 'n'.
2. Return an array answer such that answer[i] is equal to the product of all the elements of arr except arr[i].
3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

*/

import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        
        /* 
        
        find the left product and right product of an element and then muliply them to form a ans for current element
        
        */

        int rpdt[] = new int[arr.length];

        int n = arr.length;

        int pdt = 1;

        for(int i = n-1; i >= 0; i--)
        {
            rpdt[i] = pdt;
            pdt = arr[i]*pdt;
        }

        int lpdt = 1;
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
        {
            res[i] = lpdt*rpdt[i];
            lpdt = lpdt*arr[i];
        }
        return res;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
