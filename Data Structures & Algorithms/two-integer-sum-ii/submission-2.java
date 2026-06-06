class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int n=nums.length;
        int[] ans=new int[2];
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            m.put(nums[i],i);
        }
        for(int i=0;i<n;i++)
        {
            int diff=target-nums[i];
            if(m.containsKey(diff) && m.get(diff)!=m.get(nums[i]))
            {
                ans[0]=m.get(nums[i])+1;
                ans[1]=m.get(diff)+1;
                return ans;
            }
        }
        return ans;
    }
}
