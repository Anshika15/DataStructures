import java.util.*;
import java.io.*;

public class Main {

  /*
  1. Given an array of integers. Find the Inversion Count in the array.
  2. For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
  3. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
  */

  public static void main(String[]args) {
    //write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];
    
    for(int i = 0; i < n; i++)
    {
        arr[i] = s.nextInt();
    }
    
    mergeSort(arr, 0, n-1);
    System.out.println(c);
  }
  
  public static int[] mergeSort(int arr[], int lo, int hi)
  {
      if(lo == hi)
      {
          int[] res = new int[1];
          res[0] = arr[lo];
          return res;
      }
      int mid = lo + (hi-lo)/2;
      int left[] = mergeSort(arr, lo, mid);
      int right[] = mergeSort(arr, mid+1, hi);
      
      return mergeTwoArrays(left, right);
  }
  static int c = 0;
  public static int[] mergeTwoArrays(int[] l, int[] r)
  {
      int i = 0;
      int j = 0; int k = 0;
      int merge[] = new int[l.length+r.length];
      
      while(i < l.length && j < r.length)
      {
          if(l[i] <= r[j])
          {
              merge[k] = l[i];
              i++;
              k++;
          }
          else
          {
              c += l.length-i;
              merge[k] = r[j];
              j++;
              k++;
          }
      }
      
      while(i < l.length)
      {
        merge[k] = l[i];
        i++;
        k++;
      }
      while(j < r.length)
      {
        merge[k] = r[j];
        j++;
        k++;
      }
      return merge;
  }
}
