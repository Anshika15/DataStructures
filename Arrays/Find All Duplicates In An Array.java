import java.util.*;
/* 
Find All Duplicates In An Array

1. Given an integer array nums of length n where all the integers of nums are in the range [1, n].
2. Each integer appears once or twice, return an array of all the integers that appears twice.
3. You must write an algorithm that runs in O(n) time and uses only constant extra space.

*/
public class Main {

  public static List<Integer> findDuplicates(int[] nums) {
    
    /* 
    
    i) find index and mark its presence.
    ii) if already marked that means duplicacy encounter. add the duplicate eleemnt in answer
    
    idx = val-1 and to mark convert the element to -ve
    */
    
    List<Integer> res = new ArrayList<>();
    
    for(int i = 0; i < nums.length; i++)
    {
       int idx = Math.abs(nums[i]) - 1;
       int val = nums[idx];
       if(val < 0)
       {
           res.add(idx+1);
       }
       else{
           nums[idx] *= -1;
       }
       
    }
    return res;
  }

  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    List<Integer> res = findDuplicates(arr);
    if (res.size() == 0) {
      System.out.println("Empty");
      return;
    }
    Collections.sort(res);
    for (int val : res)
      System.out.print(val + " ");
    System.out.println();
  }
}
