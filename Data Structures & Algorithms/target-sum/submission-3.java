class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> memo = new HashMap<>();
        return check(target,0,nums,memo);
    }
    private int check(int target,int i,int[] nums,Map<String,Integer> memo){
        if(i==nums.length){
            return target==0?1:0;
        }
        String key = i+","+target;
        if(memo.containsKey(key)) return memo.get(key);
        int ans= check(target-nums[i],i+1,nums,memo)+check(target+nums[i],i+1,nums,memo);
        memo.put(key,ans);
        return memo.get(key);
    }
}
