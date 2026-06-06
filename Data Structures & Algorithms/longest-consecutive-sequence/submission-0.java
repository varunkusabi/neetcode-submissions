class Solution {
    public int longestConsecutive(int[] nums)
    {
        Map<Integer,Boolean> m=new HashMap<>();
        for(int i:nums)
        {
            m.put(i,true);
        }
        int ans=0;
        for(Map.Entry<Integer,Boolean> entry:m.entrySet())
        {
            int num=entry.getKey();
            if(m.containsKey(num-1)==false)
            {
                int currnum=num;
                int streak=1;
            
                while(m.containsKey(currnum+1))
                {
                    streak++;
                    currnum++;
                }
                ans=Math.max(ans,streak);
            }
        }
        return ans;
    }
}