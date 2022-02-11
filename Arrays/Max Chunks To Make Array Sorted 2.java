import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {


        // find left max for each elemnt and right min
        /* any value max from o to i is present at leftmax[i] && 
            similarly  for right min array any min val from i to array length 
            is present on rightmin[i]

            max till now is less than equal to the min from next then it will make a chunk
        */
        
        int rmin[] = new int[arr.length+1];
        rmin[arr.length] = Integer.MAX_VALUE;
        for(int i = arr.length-1; i >= 0; i--)
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        
        int lmax = arr[0];
        int c = 0;
        for(int i = 0; i < arr.length; i++)
        {
            lmax = Math.max(lmax, arr[i]);
            if(lmax <= rmin[i+1])
                c++;
        }
        
        return c;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
