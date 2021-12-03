/*
1.Given an integer array.
 2.You have to find the contiguous subarray within an array (containing at least one number) which has the largest product.
 3.You have to complete the function max() that should retuen an Integer
*/

 import java.util.Scanner;
 
 public class Main {
 
 	 public static int max(int[] a) {
 	     
 	     /* either our ans lies in subarray starting from left or starting from right */
 	     
 	     /* in case of zero break te subarray and start a fresh */
 	     
 	     int ans = Integer.MIN_VALUE;
 	     
 	     int currProd = 1;
 	     for(int i = 0; i < a.length; i++)
 	     {
 	         currProd *= a[i];
 	         ans = Math.max(ans, currProd);
 	         if(currProd == 0)
 	         {
 	             currProd = 1;
 	         }
 	     }
 	     
 	     currProd = 1;
 	     for(int i = a.length-1; i >= 0; i--)
 	     {
 	         currProd *= a[i];
 	         ans = Math.max(ans, currProd);
 	         if(currProd == 0)
 	         {
 	             currProd = 1;
 	         }
 	     }
        return ans;
 
 	 }
 
 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 int n = s.nextInt();
 	 	 int[] a = new int[n];
 	 	 for (int i = 0; i < a.length; i++) {
 	 	 	 a[i] = s.nextInt();
 	 	 }
 	 	 System.out.println(max(a));
 
 	 }
 
 }
