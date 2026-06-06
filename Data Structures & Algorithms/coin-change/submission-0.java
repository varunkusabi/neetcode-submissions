class Solution {
    private int check(int i,int target,int[] coins)
    {
        if(target==0)
        {
            return 0;
        }
        if(target<0 || i>=coins.length)
        {
            return Integer.MAX_VALUE;
        }
        int pick=check(i,target-coins[i],coins);
        if(pick!=Integer.MAX_VALUE)
        {
            pick=1+pick;
        }
        int skip=check(i+1,target,coins);
        return Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int ans= check(0,amount,coins);
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
}
