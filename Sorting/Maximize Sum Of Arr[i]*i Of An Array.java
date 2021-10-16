import java.util.*;

public class Main {

    public static int maximise(int[]arr) {
        int res = 0;
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++)
        {
            res += arr[i]*i;
        }
        return res;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}
