class Solution {
    public boolean mergeTriplets(int[][] tri, int[] target) {
        int n=tri.length;
        boolean x=false,y=false,z=false;
        for(int i=0;i<n;i++){
            if(tri[i][0]>target[0] || tri[i][1]>target[1] || tri[i][2]>target[2]){
                continue;
            }
            if(tri[i][0]==target[0]){
                x=true;
            }
            if(tri[i][1]==target[1]){
                y=true;
            }
            if(tri[i][2]==target[2]){
                z=true;
            }
            if((x && y)&&z){
                return true;
            }
        }
        return false; 
    }
}
