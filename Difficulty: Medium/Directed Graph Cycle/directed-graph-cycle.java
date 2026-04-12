// DFS

/*
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] pathVisited = new int[V];
        int[] visited = new int[V];
       
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                if(dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        } 
        
        return false;
        
    }
    
    private boolean dfs(int i, int[] visited, int[] pathVisited, List<List<Integer>> adj) {
        
        visited[i] = 1;
        pathVisited[i] = 1;
        
        for(int neighbour : adj.get(i)) {
            if(visited[neighbour] == 1 && pathVisited[neighbour] == 1) {
                return true;
            }
            
            else if(visited[neighbour] == 0) {
                if(dfs(neighbour, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }
        
        
        pathVisited[i] = 0;
        
        return false;
    }
}

*/

// BFS

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] indegree = new int[V];
        
        // Calculate indegree
        for(int i = 0; i < V; i++) {
            for(int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add nodes with indegree 0
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0; // FIXED

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            count++;

            for(int neighbour : adj.get(currNode)) {
                indegree[neighbour]--;

                if(indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // If processed nodes != V → cycle exists
        return count != V;
    }
}



























