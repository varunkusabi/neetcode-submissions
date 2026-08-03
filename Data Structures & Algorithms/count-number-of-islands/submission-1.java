class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int ans=0;
        Queue <int[]> q= new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    q.add(new int[]{i,j});
                    vis[i][j]=1;
                    ans++;
                    while(!q.isEmpty()){
                        int[] currentPair = q.poll();
                        int x= currentPair[0];
                        int y= currentPair[1];
                        if(x+1<n && grid[x+1][y]=='1' && vis[x+1][y]==0){
                            vis[x+1][y]=1;
                            q.add(new int[]{x+1,y});
                        }
                        if(x-1>=0 && grid[x-1][y]=='1' && vis[x-1][y]==0){
                            vis[x-1][y]=1;
                            q.add(new int[]{x-1,y});
                        }
                        if(y+1<m && grid[x][y+1]=='1' && vis[x][y+1]==0){
                            vis[x][y+1]=1;
                            q.add(new int[]{x,y+1});
                        }
                        if(y-1>=0 && grid[x][y-1]=='1' && vis[x][y-1]==0){
                            vis[x][y-1]=1;
                            q.add(new int[]{x,y-1});
                        }
                    }
                }
            }
        }
        return ans;
    }
}
