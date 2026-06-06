class Solution {
    int[] memo;
    private int solve(int[] cost,int i)
    {
        if(i>=cost.length)
        {
            return 0;
        }
        if(memo[i]!=-1)
        {
            return memo[i];
        }

        memo[i]=cost[i]+Math.min(solve(cost,i+1),solve(cost,i+2));

        return memo[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        memo=new int[cost.length];
        Arrays.fill(memo,-1);


        return Math.min(solve(cost,0),solve(cost,1));
    }
}
