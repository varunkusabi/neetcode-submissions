class Solution {
    int[] memo;
    int[] nums;
    private int solve(int i)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(memo[i]!=-1)
        {
            return memo[i];
        }

        memo[i]=Math.max(solve(i+1),nums[i]+solve(i+2));
        return memo[i];
    }
    public int rob(int[] nums) {
        this.nums=nums;
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return solve(0);
    }
}
