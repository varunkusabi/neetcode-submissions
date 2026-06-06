class Solution {
    public int jump(int[] nums) {
        Map <Integer,Integer> m =new HashMap<>();
        return dfs(nums, 0,m); 
    }
    private int dfs(int[] nums,int i,Map<Integer,Integer> m){
        if(m.containsKey(i)){
            return m.get(i);
        }
        if(i==nums.length-1){
            return 0;
        }
        if(nums[i]==0){
            return 1000000;
        }
        int res = 1000000;
        int end = Math.min(nums.length-1,i+nums[i]);
        for(int j=i+1;j<=end;j++){
            res = Math.min(res,1+dfs(nums,j,m));
        }
        m.put(i,res);
        return res;
    }
}
