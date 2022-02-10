/* 

Median Of Two Sorted Arrays


Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.


*/


import java.util.*;
import java.io.*;

public class Main {

    public static double find(int[]a1,int[]a2) {
        int merge[] = mergeTwoArrays(a1, a2);

        double median = 0.0;
        int mid = merge.length/2;

        

        if(merge.length%2 == 1)
        {
            median = merge[mid];
           
        }
        else{
             median = (merge[mid]+merge[mid-1])/2.0;
        }
        return median;
    }

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

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for(int i=0;i < n1;i++){
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for(int i=0; i < n2;i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a,b);
        System.out.println(median);
    }
}
