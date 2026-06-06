class Solution {
    void check(int[] can,int k,int i,int n,List<Integer> sub,List<List<Integer>> ans)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(k<0 || i>=n)
        {
            return;
        }
        
        sub.add(can[i]);
        check(can,k-can[i],i+1,n,sub,ans);
        while(i+1<n && can[i]==can[i+1])
        {
            i++;
        }
        sub.remove(sub.size()-1);
        check(can,k,i+1,n,sub,ans);
    }
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        Arrays.sort(can);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        check(can,target,0,can.length,sub,ans);
        return ans;
    }
}
