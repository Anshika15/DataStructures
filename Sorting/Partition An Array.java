import java.io.*;
import java.util.*;

/*

1. You are given an array(arr) of integers and a pivot.
2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
3. You have to achieve this in linear time.

*/

public class Main {

  public static void partition(int[] arr, int pivot){
    
    /* 0 to j-1 <--> <= pivot (less than equal to pivot)
       j to i-1 <--> > pivot (greater than pivot)
       i to end <--> unknown (unknown)
    */
    
    int i = 0, j = 0;
    
    while(i < arr.length)
    {
        if(arr[i] > pivot)
            i++;
        else // (arr[i] <= pivot)
        {
            swap(arr, i, j);
            i++;
            j++;
        }
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = scn.nextInt();
    partition(arr,pivot);
    print(arr);
  }

}
