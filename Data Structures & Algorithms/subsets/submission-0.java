class Solution {
    void check(int[] nums,int i,int n,List<Integer> sub,List<List<Integer>> ans)
    {
        if(i>=n)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        check(nums,i+1,n,sub,ans);

        sub.remove(sub.size()-1);
        check(nums,i+1,n,sub,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        check(nums,0,nums.length,sub,ans);
        return ans;
    }
}
