import java.util.*;

/* 

Number Of Subarrays With Bounded Maximum

1. We have an array 'arr' of positive integers, and two positive integers left and right (left is smaller than right).
2. Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.

*/

public class Main {

  public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
    // approach 1 => generate all subarrays, find max and increment count if max is in range
    
  //  O(n^2)
    
    /* 
    
    O(n) approach
    
    approach 2 => find breakpoints in array
    
    breakpoints are those whose value is grater than upper bound given to us.
    
    lets say range is [3-7],
    
    array is 7 4 3 9 2 8 6 5 11 4 5 12
    breakpoints are 9, 8, 11, 12
    
    now calculate counts in subarray 7 to 3, 
    for subarray 2, for subarray 6 to 5, and for subarray 4 to 5
    
    and return your result as submattion of all.
    */
    
    /* 
    
    left = 3 and right = 7
    
    case1 => left <= arr[endIdx] <= right
    
    eg; [3,1,4,5] subarrays ending at 5 are
    5, 45, 145, 3145 and max for all is 5
    
    therefore the count would increase by 4;
    i.e, endIdx - startIdx + 1
    
    ==> { 
            prevCount = endIdx - startIdx + 1;
            Count += prevCount
        }
        
        
    case 2 => arr[endIdx] < left
    eg; [3,1,4,1]
    
    so subarrays ending at 1 are, 1, 41, 141, 3141
    the count for this is same as prevcount;
    therefore add prevcount to count;
    
    ==> { Count += prevCount }
    
    case3 => right < arr[endIdx]
    
    eg; [3,1,4,8] subarrays are 8, 48, 148, 3148
    reset the startidx;
    
    { 
        startIdx = endIdx+1; 
        prevCount = 0;
    }
    
    */
    
    int startIdx = 0;
    int endIdx = 0;
    
    int n = arr.length;
    int ans = 0;
    int prevCount = 0;
    int result = 0;
    while(endIdx < n)
    {
        if(left <= arr[endIdx] && arr[endIdx] <= right)
        {
            prevCount = endIdx - startIdx + 1;
            result += prevCount;
            
        }
        else if(arr[endIdx] < left)
        {
            result += prevCount;
        }
        else
        {
            startIdx = endIdx + 1;
            prevCount = 0;
        }
        endIdx++;
    }
    return result;
    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int left = scn.nextInt();
    int right = scn.nextInt();

    int count = numSubarrayBoundedMax(arr, left, right);
    System.out.println(count);
  }
}
