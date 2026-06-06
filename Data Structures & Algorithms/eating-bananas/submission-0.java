class Solution {
    public boolean check(int[] p,int mid,int h)
    {
        long sum=0,ctr=0;
        for(int i=0;i<p.length;i++)
        {
            if(p[i]<=mid)
            {
                sum=sum+1;
            }
            else
            {
                if(p[i]%mid==0)
                {
                    sum=sum+p[i]/mid;
                }
                else
                {
                    sum=sum+(p[i]/mid)+1;
                }
            }
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h)
    {
        int low=1,high=Arrays.stream(piles).max().getAsInt();
        int ans = high;
        int n=piles.length;
        while(low<=high)
        {
            int mid=(low+(high-low)/2);
            if(check(piles,mid,h))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
