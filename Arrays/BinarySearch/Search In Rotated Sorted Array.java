/* 
Search In Rotated Sorted Array

1. There is an integer array nums sorted in ascending order (with distinct values).
2. nums is rotated at an unknown pivot index k

*/


import java.util.*;
import java.io.*;

public class Main {

    public static int find(int[]arr,int target) {
        
        /* find mid and then discard the part which is already sorted */

        int i = 0;
        int j = arr.length-1;

        while(i <= j)
        {
            int mid = i + (j-i)/2;

            if(arr[mid] == target)
                return mid;
            if(arr[i] <= arr[mid])
            {
                // checking low to mid part is sorted
                if(target >= arr[i] && target < arr[mid])
                {
                    // then our value lies in this range only so search here
                    j = mid-1;
                }
                else
                {
                    i = mid+1;
                }
            }
            else if(arr[mid] <= arr[j]) // check whether mid to high part is sorted or not
            {
                if(target >= arr[mid] && target < arr[j])
                {
                    // then our value lies in this range only so search here
                    i = mid+1;
                }
                else
                {
                    j = mid-1;
                }
            }

        }

        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }
}
