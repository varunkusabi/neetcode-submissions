class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected: add both directions
        }

        boolean[] vis = new boolean[n];

        if(dfs(0,-1,vis,adj)){
            return false;
        }

        for(boolean v:vis){
            if(!v){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node,int parent,boolean[] vis,List<List<Integer>> adj){
        vis[node] = true;
        for(int ne:adj.get(node)){
            if(ne==parent){
                continue;
            }

            if(vis[ne]){
                return true;
            }

            if(dfs(ne,node,vis,adj)){
                return true;
            }
        }
        return false;
    }
}
