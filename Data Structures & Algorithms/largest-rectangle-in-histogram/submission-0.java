class Solution {
    public int largestRectangleArea(int[] heights)
    {
        int n=heights.length;
        int maxarea=0;
        Stack<int[]> s=new Stack<>(); //pair (index,height)

        for(int i=0;i<n;i++)
        {
            int start=i;
            while(!s.isEmpty() && s.peek()[1]>heights[i])
            {
                int[] top=s.pop();
                int index=top[0];
                int height=top[1];
                maxarea=Math.max(maxarea,height*(i-index));
                start=index;
            }
            s.push(new int[]{start,heights[i]});
        }

        for(int[] pair:s)
        {
            int index=pair[0];
            int height=pair[1];
            maxarea=Math.max(maxarea,height*(n-index));
        }
        return maxarea;
        
    }

}
