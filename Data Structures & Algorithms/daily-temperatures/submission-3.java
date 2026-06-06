class Solution {
    public int[] dailyTemperatures(int[] temp)
    {
        int n=temp.length;
        int[] ans=new int[n];
        for(int i=n-2;i>=0;i--)
        {
            int j=i+1;
            while(j<n && temp[j]<=temp[i])
            {
                if(ans[j]==0)
                {
                    j=n;
                    break;
                }
                j=j+ans[j];
            }
            if(j<n)
            {
                ans[i]=j-i;
            }
        }
        return ans;
    }
}
