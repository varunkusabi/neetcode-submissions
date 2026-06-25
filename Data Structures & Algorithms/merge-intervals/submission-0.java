class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n=intervals.length;
        Arrays.sort(intervals, (p, q) -> Integer.compare(p[0], q[0]));
        int x = intervals[0][0];
        int y = intervals[0][1];

        for(int i=1;i<n;i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            if(a>y){
                ans.add(new int[]{x,y});
                x=a;
                y=b;
            }
            else{
                y=Math.max(y,b);
            }
        }
        ans.add(new int[]{x,y});
        return ans.toArray(new int[ans.size()][]);
    }
}
