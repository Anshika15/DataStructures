import java.util.*;

public class Main {

    public static int findMaxSteps(int[]arr) {
        int N = arr.length;
        int c = 0;
        int max = 0;
        for(int i = 0; i < N-1; i++)
        {
            if(arr[i] < arr[i+1])
                c++;
            else
            {
                max = Math.max(max, c);
                c = 0;
            }
        }
        return Math.max(max, c);
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}
