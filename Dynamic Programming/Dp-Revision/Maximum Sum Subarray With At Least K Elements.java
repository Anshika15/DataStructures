import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr, int k) {
    // at each point find the max sum subarray using kadanes
    // not keep a window of size k and add the max sum subarray before that window size and keep on checking max val
    
    int currSum = arr[0];
    
    int[] maxSumArr = new int[arr.length]; // kadanes ans
    maxSumArr[0] = arr[0];
    for(int i = 1; i < arr.length; i++)
    {
        if(currSum > 0)
        {
            currSum += arr[i];
        }
        else
        {
            currSum = arr[i];
        }
        maxSumArr[i] = currSum;
    }
    int res = Integer.MIN_VALUE;
    int exactK = 0;
    for(int i = 0; i< k; i++)
    {
        exactK += arr[i];
    }
    
    res = Math.max(res, exactK);
    
    for(int i = k; i < arr.length; i++)
    {
        exactK = exactK + arr[i] - arr[i-k]; // to keep window of size k only
        
        res = Math.max(res, exactK);
        int atleastk = exactK + maxSumArr[i - k];
        res = Math.max(res, atleastk);
    }
    

    return res;
  }
  

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k));
  }
}
