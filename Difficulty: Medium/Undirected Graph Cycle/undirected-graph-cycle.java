// DFS

/*
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
*/

/*
import java.util.*;

class Solution {
    
    static class Pair {
        int node;
        int parent;
        
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    
    public boolean isCycle(int V, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build adjacency list
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            
            if(!visited[i]) {
                if(cycleCheckDFSUsingStack(i, visited, adj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    private boolean cycleCheckDFSUsingStack(int start,
                                            boolean[] visited,
                                            List<List<Integer>> adj) {
        
        Stack<Pair> stack = new Stack<>();
        
        stack.push(new Pair(start, -1));
        
        while(!stack.isEmpty()) {
            
            Pair current = stack.pop();
            
            int node = current.node;
            int parent = current.parent;
            
            if(!visited[node]) {
                visited[node] = true;
            }
            
            for(int neighbour : adj.get(node)) {
                
                if(!visited[neighbour]) {
                    stack.push(new Pair(neighbour, node));
                }
                
                else if(neighbour != parent) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

*/

// BFS

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
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
            if(visited[i] == false) {
                if(checkCycleBFS(i, visited, adj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean checkCycleBFS(int src, boolean[] visited, List<List<Integer>> adj) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        visited[src] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currNodeParent = curr[1];
            
            for(int neighbour : adj.get(currNode)) {
                if(visited[neighbour] == false) {
                    queue.offer(new int[]{neighbour, currNode});
                    visited[neighbour] = true;
                }
                else if(neighbour != currNodeParent) {
                    return true;
                }
            }
        }
        
        return false;
    }
}








