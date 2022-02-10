/* 

Allocate Minimum Number Of Pages

1. You are given N number of books. Every ith book has Ai number of pages. 
2. You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value. 
3. Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
4. Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.

*/


import java.util.*;
import java.io.*;

public class Main {

  public static int minPages(int[]arr, int m) {
    //write your code here


    /* 
    
    if m > arr.length then distribution is not at all possible as we cannot break books
    if m == arr.length then max value of pages in array is our result as some one has to read that book also

    if m < arr.length then the minimum load one can get is of max value in array as someone has to read that book and min what we can do is assign it alone
    and max load we dont know but lets say highest = sum of array (it can’t be equal to sum of array as we have to distribute the books in all)

    we took it as such so that we can define a range between low & high
    
    find the students which we can allocate by keeping the max stress as mid and then discard the parts accordingly(binary search)

    if the students count is more for current load then we need to increase the load
    
    */


    int sum = 0;
    int max = 0;

    for(int i = 0; i < arr.length; i++)
    {
      sum += arr[i];
      max = Math.max(max, arr[i]);
    }

    if(m == arr.length)
      return max;

    int lo = max;

    int hi = sum;
    int ans = 0;

    while(lo <= hi)
    {
      int mid = lo + (hi-lo)/2;

      if(isPossible(arr, mid, m))
      {
        ans = mid;
        hi = mid-1;
      }
      else
      {
        lo = mid+1;
      }
    }

    return ans;
  }


  public static boolean isPossible(int[] arr, int load, int students)
  {
    int st = 1;
    int sum = 0;

    for(int i = 0; i < arr.length; i++)
    {
       sum += arr[i];
       if(sum > load)
       {
         sum = arr[i];
         st++;
       }
    }

    return st <= students;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = minPages(arr, m);
    System.out.println(ans);
  }
}
