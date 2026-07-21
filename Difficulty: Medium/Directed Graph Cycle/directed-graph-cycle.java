class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                if(dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int neighbour : adj.get(node)) {
            if(visited[neighbour] == false) {
                if(dfs(neighbour, adj, visited, pathVisited)) {
                    return true;
                }
            }
            else if(pathVisited[neighbour]) {
                return true;
            }
        }
        
        pathVisited[node] = false;
        return false;
    }
}