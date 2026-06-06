class Solution {
    void check(int[] nums,int k,int i,int n,List<Integer> sub,List<List<Integer>>ans)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(i>=n || k<0)
        {
            return;
        }
        sub.add(nums[i]);
        check(nums,k-nums[i],i,n,sub,ans);        
        sub.remove(sub.size()-1);
        check(nums,k,i+1,n,sub,ans);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub= new ArrayList<>();
        check(nums,target,0,nums.length,sub,ans);
        return ans;
    }
}
