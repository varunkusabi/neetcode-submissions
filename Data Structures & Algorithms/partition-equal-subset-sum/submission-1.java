class Solution {
    Boolean[][] dp;
    public boolean check(int target, int sum, int i, int[] nums, int n) {
        if (i >= n) {
            return false;
        }

        if (target == sum) {
            return true;
        }
        if(dp[target][i]!=null)
        {
            return dp[target][i];
        }
        dp[target][i]=check(target + nums[i], sum - nums[i], i + 1, nums, n) 
            || check(target, sum, i + 1, nums, n);
        
        return dp[target][i];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        int n=nums.length;
        dp=new Boolean[sum+1][n+1];
        return check(0, sum, 0, nums, n);
    }
}