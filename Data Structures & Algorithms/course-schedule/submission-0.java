class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre:prereq){
            adj.get(pre[1]).add(pre[0]);
        }
        
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i])
            {
                if(dfs(i,adj,vis,path)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i,List<List<Integer>> adj,boolean[] vis,boolean[] path){
        vis[i] = true;
        path [i] = true;

        for(int ne:adj.get(i)){
            if(!vis[ne]){
                if(dfs(ne,adj,vis,path)){
                    return true;
                }
            }
            else if(path[ne]){
                return true;
            }
        }

        path[i] = false;
        return false;
    }
}
