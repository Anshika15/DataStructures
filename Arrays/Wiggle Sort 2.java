/* 

Wiggle Sort 2

1. Given an integer array 'arr'.
2. Reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
3. You may assume the input array always has a valid answer.
Note : You can return answer in any order.

*/


import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User''s Section~~~~~~~~~~~~
  public static void wiggleSort2(int[] nums) {

    /* 
    
    lets say aorted array is a b c d e f

    start from last idx in sorted array in res array start from idx = 1 and increment it by +2 only and idx++
    once array size finished then start with idx = 1 & go till last idx;
    ans == c f b e a d
    */

    // sort array
    Arrays.sort(nums);

    //make an extra array & manage equality in it
    int[] res = new int[nums.length];
    int n = nums.length;
    int i = 1;
    int j = nums.length-1;

    while(i < n)
    {
      res[i] = nums[j];
      j--;
      i+=2;
    }
    i = 0;
    while(i < n)
    {
      res[i] = nums[j];
      j--;
      i+=2;
    }

    //chnge it in original array
    for(i = 0; i < nums.length; i++)
      nums[i] = res[i];
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    wiggleSort2(arr);
    /*
    -if index is even then smaller than next,
    -if index is odd then greater than next element,
    -to check any correct order, we will not print array, we will check inequality
    -if print false, that means wrong answer, if true than correct answer.
    */
    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
        System.out.println(false);
        return;
      } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
        System.out.println(false);
        return;
      }
    }
    System.out.println(true);
  }
}
