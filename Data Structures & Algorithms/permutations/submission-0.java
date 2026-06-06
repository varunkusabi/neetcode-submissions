class Solution {
    void check(int[] nums,int[] freq,List<Integer> sub,List<List<Integer>> ans)
    {
        if(sub.size()==nums.length)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(freq[i]==0)
            {
                sub.add(nums[i]);
                freq[i]=1;
                check(nums,freq,sub,ans);
                freq[i]=0;
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<Integer> sub=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int[] freq = new int[10];
        check(nums,freq,sub,ans);
        return ans;
    }
}
