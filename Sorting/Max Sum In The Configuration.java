import java.util.*;

public class Main {

    public static int maximise(int[]arr) {
        /* Si+1 = si + sum - n*arr[n-i-1] */
        int res = 0;
        int sum = 0;
        int s[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            s[0] += i*arr[i];
            res = s[0];
        }
        
        for(int i = 0; i < arr.length-1; i++)
        {
            s[i+1] = s[i] + sum - arr.length*arr[arr.length-i-1];
            res = Math.max(res, s[i+1]);
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
