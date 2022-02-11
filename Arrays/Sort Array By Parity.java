/* 

Sort Array By Parity


1. Given an array nums of non-negative integers.
2. Arrange elements of array in specific order, all even elements followed by odd elements. [even -> odd]
3. Preserve the order of Even elements without using extra space.
4. Hence question is order specific so you have to match your output in order of given output.

*/

import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    
    public static void sortArrayByParity(int[] nums) {
        // write your code here
         int i = 0; // first unsolved
        int j = 0; // first odd
        
        while(i < nums.length)
        {
            if(nums[i]%2 == 0)
            {
                // swap arr, i, j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        
        return;
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
