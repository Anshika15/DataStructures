import java.util.*;
import java.io.*;

public class Main {

  /*
  1. Given an array arr of size n, you need to write a program to find if there exists a pair of elements in the array whose difference is equals to target.
  2. If there exists such a pair print it, otherwise print -1
  */


  public static void findPair(int[]arr, int target) {
    //write your code here
    Arrays.sort(arr);
    int i = 0;
    int j = 1;
    while(i < arr.length && j < arr.length)
    {
        if(arr[j] - arr[i] == target)
        {
            System.out.println(arr[i] + " " + arr[j]);
            return;
        }
        else if(arr[j] - arr[i] < target)
        {
            j++;
        }
        else
        {
            i++;
        }
    }
    System.out.println(-1);
  }

  public static void main(String[]args) {

    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int target = scn.nextInt();
    findPair(arr, target);
  }
}
