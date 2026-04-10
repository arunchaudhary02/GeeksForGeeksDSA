// DFS
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!visited[i] && cycleCheckDFS(i, -1, visited, adj)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean cycleCheckDFS(int src, int parent, boolean[] visited, List<List<Integer>> adj) {
        
        visited[src] = true;
        
        for(int neighbour : adj.get(src)) {
            if(visited[neighbour] == false) {
                if(cycleCheckDFS(neighbour, src, visited, adj)) {
                    return true;
                }
            }
            else if(neighbour != parent) {
                return true;
            }
        }
        
        
        return false;
    }
}
