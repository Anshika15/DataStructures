/*

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

*/
class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int val : nums)
            sum += val;
        if(sum%2 != 0)
            return false;
        
        // check if we can get target sum subset equal to sum/2
        boolean[][] dp = new boolean[nums.length+1][sum/2 + 1];
        
        for(int i = 0; i <= nums.length; i++)
        {
            for(int j = 0; j <= sum/2; j++)
            {
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(i == 0)
                    dp[i][j] = false;
                else if(j == 0)
                    dp[i][j] = true;
                else
                {
                    dp[i][j] = dp[i-1][j];
                    if(j >= nums[i-1])
                    {
                        dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }
        }
        
        return dp[nums.length][sum/2];
        
    }
}
