class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (p, q) -> Integer.compare(p[0], q[0]));
        int x = intervals[0][0];
        int y = intervals[0][1];
        int ctr=0;
        int prevend = y;
        for(int i=1;i<n;i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            if(a>=prevend){
                x=a;
                y=b;
                prevend = b;
            }
            else{
                ctr++;
                prevend = Math.min(prevend,b);
            }
        }
        return ctr;
    }
}
