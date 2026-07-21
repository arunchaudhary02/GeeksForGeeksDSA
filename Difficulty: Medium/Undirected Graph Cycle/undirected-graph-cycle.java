class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                if(checkCycle(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean checkCycle(int currNode, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[currNode] = true;
        
        for(int neighbour : adj.get(currNode)) {
            if(neighbour == parent) continue;
            
            if(visited[neighbour]) {
                return true;
            }
            
            if(checkCycle(neighbour, currNode, adj, visited)){
                return true;
            }
        }
        
        return false;
    }
}