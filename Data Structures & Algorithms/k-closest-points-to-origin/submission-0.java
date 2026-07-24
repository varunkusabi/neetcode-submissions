class Solution {
    public int[][] kClosest(int[][] po, int k) {
        PriorityQueue<int[]> mh = new PriorityQueue<>((a, b)->Integer.compare(b[0],a[0]));
        for(int i =0;i<po.length;i++){
            int dist = po[i][0]*po[i][0]+po[i][1]*po[i][1];
            mh.add(new int[]{dist,i});
            if(mh.size()>k){
                mh.poll();
            }
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            int pt=mh.poll()[1];
            ans[i]=po[pt];
        }
        return ans;

    }
}
