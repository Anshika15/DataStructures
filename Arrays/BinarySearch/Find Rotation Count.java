/* 
Find Rotation Count

1. Given an ascending sorted rotated array arr of distinct integers of size N. 
2. The array is right rotated K times. 
3. Your task is to find the value of K.
*/


import java.util.*;

public class Main {

    public static int findRotationCount(int[]arr) {

        // find the minimum element and return the index for the same
        // we will find our ans in unsorted part

        int lo = 0;
        int hi = arr.length - 1;

        // if array is completely sorted return arr[0];

        if(arr[lo] <= arr[hi])
            return 0;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;

            if(arr[mid] > arr[mid+1]) // if we keep this condition before the other one then it will work as there are chances that mid-1 will not exist but mid+1 will always exist as we had already aorted out our array
            {
                return mid+1;
            }
            else if(arr[mid] < arr[mid-1])
            {
                return mid;
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

        return 0;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findRotationCount(arr);
        System.out.println(ans);
    }
}
