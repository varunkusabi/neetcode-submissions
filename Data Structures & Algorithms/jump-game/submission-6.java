class Solution {
    public boolean canJump(int[] nums) {
        Map <Integer,Boolean> m = new HashMap<>();
        return dfs(nums,0,m);
    }

    public boolean dfs(int[] nums,int i,Map <Integer,Boolean> m){
        if(m.containsKey(i)){
            return m.get(i);
        }
        if(i==nums.length-1){
            return true;
        }

        int end = Math.min(nums.length-1,i+nums[i]);
        for(int j=i+1;j<=end;j++){
            if(dfs(nums,j,m)){
                m.put(i,true);
                return true;
            }
        }
        m.put(i,false);
        return false;
    }
}
