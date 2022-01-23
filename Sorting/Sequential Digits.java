/*
Sequential Digits

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.


*/

import java.util.*;

public class Main {


    /* sequential digits with n (number of digits in a number) = 2,3,4...9 */
    /* 2 => 12, 23, 34, 45, 56, 67, 78, 89  ============== 8 */
    /* 3 => 123, 234, 345, 456, 567, 678, 789  ============== 7 */
    /* 4 => 1234, 2345, 3456, 4567, 5678, 6789 ============== 6 */
    /* 5 => 12345, 23456, 34567, 45678, 56789 ============== 5 */
    /* 6 => 123456, 234567, 345678, 456789 ============== 4 */
    /* 7 => 1234567, 2345678, 3456789 ============== 3 */
    /* 8 => 12345678, 23456789 ============== 2 */
    /* 9 => 123456789 */
    
    /* these are the only digites which are possible so create a array with it and then retur the ans within range */
  
  public static ArrayList<Integer> sequentialDigits(int low, int high) {
    int[] arr = {
        12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789,
        1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789,
        123456, 234567, 345678, 456789, 1234567, 2345678, 3456789,
        12345678, 23456789, 123456789
    };
    
    ArrayList<Integer> res = new ArrayList<Integer>();
    
    for(int i = 0; i < arr.length; i++)
    {
        if(arr[i] < low)
            continue;
        if(arr[i] > high)
            break;
        else
            res.add(arr[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    ArrayList<Integer> ans = sequentialDigits(n, m);
    for (int ele : ans) {
      System.out.print(ele + " ");
    }
  }
}
