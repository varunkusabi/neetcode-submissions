class Solution {
    public int[] dailyTemperatures(int[] temp)
    {
        Stack<Integer> s=new Stack<>();
        int n=temp.length;
        int[] ans=new int[n];
        ans[n-1]=0;
        s.push(n-1);
        int i=n-2;
        while(i>=0)
        {
            if(temp[s.peek()]>temp[i])
            {
                if(s.empty())
                {
                    ans[i]=0;
                }
                else
                {
                    ans[i]=s.peek()-i;
                }
            }
            else
            {
                while(!s.isEmpty() && temp[s.peek()]<=temp[i])
                {
                    s.pop();
                }
                if(s.empty())
                {
                    ans[i]=0;
                }
                else
                {
                    ans[i]=s.peek()-i;
                }
            }
            s.push(i);
            i--;
        }
        return ans;
    }
}
