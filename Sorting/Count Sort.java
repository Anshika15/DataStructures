import java.io.*;
import java.util.*;

public class Main {
    
  /*
    1. You are given an array(arr) of integers.
    2. You have to sort the given array in increasing order using count       sort.
  */

  public static void countSort(int[] arr, int min, int max) {
   // count sort is used when there is lots of values but range is less
   
   int range = max - min + 1;
   int[] freq = new int[range];
   
   for(int i = 0; i < arr.length; i++)
   {
       int idx = arr[i] - min;
       freq[idx]++;
   }
   
    // to keep the count sort stable we use prefix sum technique
   
   for(int i = 0; i < freq.length; i++)
   {
       if(i == 0)
        continue;
       freq[i] = freq[i] + freq[i-1]; // stor ethe prefix sum in freq
   }
   
   int ans[] = new int[arr.length];
   
   for(int i = arr.length-1; i >= 0; i--)
   {
        int val = arr[i];
        int pos = freq[val - min] - 1;
        ans[pos] = val;
        freq[val-min]--;
   }
  
   for(int i = 0; i < arr.length; i++)
   {
       arr[i] = ans[i];
   }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
