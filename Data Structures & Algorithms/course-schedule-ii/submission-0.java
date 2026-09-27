class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre:prereq){
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,path,order)){
                    return new int[0]; //cycle detected
                }
            }
        }

        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]= order.get(numCourses-i-1);
        }

        return result;
    }

    private boolean dfs(int node,List<List<Integer>> adj, boolean[] vis, boolean[] path, List<Integer> order) {
        vis[node] = true;
        path[node] = true;

        for(int ne:adj.get(node)){
            if(!vis[ne]){
                if(dfs(ne,adj,vis,path,order)){
                    return true;
                }
            }
            else if(path[ne]){
                return true;
            }
        }

        path[node] = false;
        order.add(node);
        return false;
    }
}
