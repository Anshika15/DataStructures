/* 

Count Zeros Xor Pairs

1. Given an array A[] of size N. 
2. Find the number of pairs (i, j) such that A[i] XOR A[j] = 0, and 1 

*/

import java.util.*;
import java.io.*;

public class Main {
  public static int countPairs(int[]arr) {
    // A[i] xor A[j] == 0 only when A[i] == A[j] as per xor property
    // therefore, find the occurences of each elements and then to form pairs count += SumOfNNaturalNumbers(freq-1);

    HashMap<Integer, Integer> map = new HashMap<>(); // element, freq

    for(int i = 0; i < arr.length; i++)
    {
      map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    }


    int count = 0;
    for(int key : map.keySet())
    {
      int freq = map.get(key);
      freq--;
      count += (freq * (freq+1))/2;
    }

    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}
