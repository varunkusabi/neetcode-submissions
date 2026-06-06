class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,ans=Integer.MIN_VALUE;
        int i=0,n=nums.length;
        while(i<n){
            sum = Math.max(nums[i],sum+nums[i]);
            ans= Math.max(ans,sum);
            i++;
        }
        return ans;
    }
}
