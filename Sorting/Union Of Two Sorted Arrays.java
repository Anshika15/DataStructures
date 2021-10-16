import java.util.*;
import java.io.*;

public class Main {
  /*
  1. Given two sorted arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.
  2. Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.
  3. Your task is to complete Union function that takes a, b as parameters and returns an Arraylist which contains the union elements of the two arrays.The printing is done by the driver code.
  */

  /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
  public static ArrayList<Integer> union(int[] a, int[] b) {
    ArrayList<Integer> list = new ArrayList<>();

    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length)
    {
      if (a[i] == b[j])
      {
        if (list.size() > 0 && list.get(list.size() - 1) != a[i])
          list.add(a[i]);
        else if (list.size() == 0)
          list.add(a[i]);
        i++;
        j++;
      }
      else if (a[i] < b[j])
      {
        if (list.size() > 0 && list.get(list.size() - 1) != a[i])
          list.add(a[i]);
        else if (list.size() == 0)
          list.add(a[i]);
        i++;
      }
      else
      {
        if (list.size() > 0 && list.get(list.size() - 1) != b[j])
          list.add(b[j]);
        else if (list.size() == 0)
          list.add(b[j]);
        j++;
      }
    }

    while (i < a.length)
    {
      if (list.size() > 0 && list.get(list.size() - 1) != a[i])
        list.add(a[i]);
      i++;
    }
    while (j < b.length)
    {
      if (list.size() > 0 && list.get(list.size() - 1) != b[j])
        list.add(b[j]);
      j++;
    }
    return list;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    //input work
    int n = scn.nextInt();
    int[]a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[]b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = union(a, b);

    //print answer list
    for (int val : ans) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
