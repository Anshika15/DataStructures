import java.util.*;
import java.io.*;

public class Main {

    //return an array of size two, which contains first and last index of target.
    public static int[] find(int[]arr,int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        int i = 0; int j = arr.length - 1;
        while(i <= j)
        {
            int mid = i + (j - i)/2;
            if(arr[mid] == target)
            {
                res[0] = mid;
                j = mid-1;
            }
            else if(arr[mid] < target)
                i = mid+1;
            else
                j = mid-1;
        }
        
        i = 0; j = arr.length - 1;
        while(i <= j)
        {
            int mid = i + (j - i)/2;
            if(arr[mid] == target)
            {
                res[1] = mid;
                i = mid+1;
            }
            else if(arr[mid] < target)
                i = mid+1;
            else
                j = mid-1;
        }
        return res;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0;i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int[]ans = find(arr,target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
