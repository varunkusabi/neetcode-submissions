class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int n=speed.length;
        int[][] cars=new int[n][2];
        for(int i=0;i<n;i++)
        {
            cars[i][0]=pos[i];
            cars[i][1]=speed[i];
        }
        // Arrays.sort(cars,(a,b) -> b[0]-a[0]);
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));

        int fleets=1;
        double lasttime=(double)(target-cars[0][0])/cars[0][1];

        for(int i=1;i<n;i++)
        {
            double time=(double)(target-cars[i][0])/cars[i][1];
            if(time>lasttime)
            {
                fleets++;
                lasttime=time;
            }
        }
        return fleets;
    }
}
