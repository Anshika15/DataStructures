/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.
*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
        arr[i] = scn.nextInt();
    
    int end = -1;
    int max = arr[0];
    /* move from left to right and find the ending index*/
    /* while moving from l to r if we find any elemnt which is smaller then the max element till now this our ending index*/
    for(int i = 1; i < arr.length; i++)
    {
        if(max > arr[i])
            end = i;
        else 
            max = arr[i];
    }
    
    int start = 0;
    int min = arr[arr.length-1];
    /* move from right to left and find the starting index*/
    for(int i = arr.length-2; i >= 0; i--)
    {
        if(min < arr[i])
            start = i;
        else 
            min = arr[i];
    }
    
    System.out.println(end - start + 1);

  }

}
