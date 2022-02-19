/* 

Pancake Sorting

Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

*/

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> res = new ArrayList<>();
        
        // find max element from leftover array
        
        // take the max element to 0 the postion by using panckae sorting
        
        // take the element to its original position by using pancake sorting
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            int maxIdx = i;
            for(int j = i-1; j >= 0; j--)
            {
                if(arr[maxIdx] < arr[j])
                {
                    maxIdx = j;
                }
            }
            
            if(maxIdx != i)
            {
                reverse(arr, 0, maxIdx);
                res.add(maxIdx+1);
                
                reverse(arr, 0, i);
                res.add(i+1);
            }
        }
        return res;
        
    }
    
    public void reverse(int[] arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
