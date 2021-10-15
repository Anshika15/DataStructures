import java.io.*;
import java.util.*;

public class Main {

  public static void bubbleSort(int[] arr) {
    //write your code here
    
    /*
    Bubble Sort is the simplest sorting algorithm that works by repeatedly     swapping the adjacent elements if they are in wrong order.
    */
    
    for(int i = 1; i <= arr.length - 1; i++) // n-1 iterations
    {
        for(int j = 0; j < arr.length - i; j++)
        {
            if(isSmaller(arr, j+1, j))
                swap(arr, j+1, j);
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

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    bubbleSort(arr);
    print(arr);
  }

}
