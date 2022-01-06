/*
1. You are given an array(arr) of distinct integers.
2. You have to find if there are two pairs(A, B) and (C, D) present in the given array which satisfies the condition A+B = C+D.
*/
import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                int sum = arr[i] + arr[j];
                if(set.contains(sum))
                    return true;
                else
                    set.add(sum);
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
