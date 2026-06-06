class Solution {
    int memo[][];
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
        if(memo[i][target]!=-1)
        {
            return memo[i][target];
        }
        int pick=check(i,target-coins[i],coins);
        if(pick!=Integer.MAX_VALUE)
        {
            pick=1+pick;
        }
        int skip=check(i+1,target,coins);

        memo[i][target] = Math.min(pick,skip);
        return memo[i][target];
    }
    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans= check(0,amount,coins);
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
}
