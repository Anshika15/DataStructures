import java.util.*;
 
 public class Main {
 
     // This is a functional problem. You have to complete this function.
     // It takes as input a length and a 2D array of update operations.
     // It should return the modified array.
     public static int[] Range(int length, int[][] updates) {
         
         /* 
         
         when we are given any query with range we keep val on leftIdx and -val on (rightIdx + 1)

         now make the prefix sum array

         => why:-

         prefix sum array shows the imapct on whole array so it will impact till that idx and when we use -val at rigtidx+1 it will neglect that effect 

         */

         // time complexity  = O(Queries);

         int arr[] = new int[length];

         for(int i = 0; i < updates.length; i++)
         {
             int leftIdx = updates[i][0];
             int rightIdx = updates[i][1];
             int val = updates[i][2];

             arr[leftIdx] += val;
             if(rightIdx+1 < length)
                arr[rightIdx+1] -= val;
         }

        int sum = 0;
         for(int i = 0; i < length; i++)
         {
             sum += arr[i];
             arr[i] = sum;
         }
         return arr;
         
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Input for length of first array.
         int length = sc.nextInt();
 
         int K = sc.nextInt();
 
         int[][] updates = new int[K][3];
 
         for (int i = 0; i < updates.length; i++) {
             for (int j = 0; j < updates[0].length; j++) {
                 updates[i][j] = sc.nextInt();
             }
         }
 
         int[] result = Range(length, updates);
         display(result);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 
 }
