class Solution {
    Integer[][] dp;
    private int check(int[] nums,int i,int j)
    {
        if(i==nums.length)
        {
            return 0;
        }
        if(dp[i][j+1]!=null)
        {
            return dp[i][j+1];
        }
        int skip=check(nums,i+1,j);
        int notskip=0;
        if(j==-1 || nums[j]<nums[i])
        {
            notskip=(1+check(nums,i+1,i));
        }
        dp[i][j+1]=Math.max(skip,notskip);
        return dp[i][j+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n + 1]; 
        return check(nums,0,-1);
    }
}
