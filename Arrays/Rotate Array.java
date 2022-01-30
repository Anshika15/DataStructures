class Solution {
    public void rotate(int[] nums, int k) {

        /* if k is big k = k%n.  (n is array length)
           if k is less than 0 then k = k+n;
           now partition an array in two array on k as p1 and p2
           reverse p1, reverse p2
           now arrays is p1 + p2
           reverse array i.e ans == p2 + p1
        */

         k = k%nums.length;
        if(k < 0)
            k += nums.length;

        // reverse part1 i.e from 0, n - k - 1

        reverse(nums, 0, nums.length-k-1);

        // reverse part2 i.e from n-k to n-1;

        reverse(nums, nums.length-k, nums.length-1);

        // reverse whole array

        reverse(nums, 0, nums.length-1);

    }

    void reverse(int[] arr, int i, int j)
    {
        int li = i;
        int ri = j;

        while(li < ri)
        {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }
}
