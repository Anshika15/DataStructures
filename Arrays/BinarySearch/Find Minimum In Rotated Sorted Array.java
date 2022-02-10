/* 

Find Minimum In Rotated Sorted Array

1. Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
2. Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
3. Given the sorted rotated array nums of unique elements, return the minimum element of this array.

*/

import java.util.*;

public class Main {

    public static int findMinimum(int[]arr) {
        

        // we will find our ans in unsorted part

        int lo = 0;
        int hi = arr.length - 1;

        // if array is completely sorted return arr[0];

        if(arr[lo] <= arr[hi])
            return arr[lo];

        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;

            if(arr[mid] > arr[mid+1]) // if we keep this condition before the other one then it will work as there are chances that mid-1 will not exist but mid+1 will always exist as we had already aorted out our array
            {
                return arr[mid+1];
            }
            else if(arr[mid] < arr[mid-1])
            {
                return arr[mid];
            }
            else if(arr[lo] <= arr[mid]){
                // this part is sorted therefore go to other part
                lo = mid+1;
            }
            else if(arr[mid] <= arr[hi]){
                // this part is sorted therefore go to other part
                hi = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}
