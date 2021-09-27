import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int[] res = new int[nums.length];
        int index = nums.length -1;
        int i = 0;
        int j = nums.length-1;
        while(i <= j)
        {
            int val1 = nums[i]*nums[i];
            int val2 = nums[j]*nums[j];
            
            int max = Math.max(val1, val2);
            res[index] = max;
            if(max == val1)
                i++;
            else
                j--;
            index--;
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
        
        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
