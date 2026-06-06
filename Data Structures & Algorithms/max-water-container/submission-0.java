class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        int n=heights.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int area=(j-i)*(Math.min(heights[i],heights[j]));
                ans=Math.max(ans,area);
            }
        }
        return ans;
    }
}
