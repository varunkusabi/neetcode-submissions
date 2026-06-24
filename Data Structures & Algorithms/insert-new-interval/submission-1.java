class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        boolean flag = false;
        int n=intervals.length;
        int x = newInterval[0];
        int y = newInterval[1];

        for(int i=0;i<n;i++){
            int a = intervals[i][0];
            int b = intervals[i][1];

            if(b<x){
                ans.add(new int[]{a,b});
            }
            else if(a>y){
                if(!flag){
                    ans.add(new int[]{x,y});
                    flag = true;
                }
                ans.add(new int[]{a,b});
            }
            else{
                x=Math.min(x,a);
                y=Math.max(y,b);
            }
        }

        if(!flag){
            ans.add(new int[]{x,y});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
