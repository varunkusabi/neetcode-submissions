class Solution {
    private void check(int[] nums,int ind,List<Integer> sub,List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(sub));
        for(int i=ind;i<nums.length;i++)
        {
            if(i!=ind && nums[i]==nums[i-1])
            {
                continue;
            }
            sub.add(nums[i]);
            check(nums,i+1,sub,ans);
            sub.remove(sub.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        check(nums,0,sub,ans);
        return ans;
    }
}