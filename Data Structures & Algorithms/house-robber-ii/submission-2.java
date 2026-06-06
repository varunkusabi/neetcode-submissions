class Solution {
    int[] memo;
    private int solve(int i,int[] nums,int n){
        if(i>n)
        {
            return 0;
        }
        if(memo[i]!=-1)
        {
            return memo[i];
        }
        memo[i]=Math.max(solve(i+1,nums,n),nums[i]+solve(i+2,nums,n));
        return memo[i];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        int a=solve(0,nums,nums.length-2); 
        Arrays.fill(memo,-1);
        int b=solve(1,nums,nums.length-1); 
        return Math.max(a,b);
    }
}
