//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


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
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                if(dfs(i, visited, pathVisited, stack, adj)) {
                    return true;
                }
            }
        } 
        
        return false;
        
    }
    
    private boolean dfs(int i, int[] visited, int[] pathVisited, Stack<Integer> stack, List<List<Integer>> adj) {
        
        visited[i] = 1;
        pathVisited[i] = 1;
        
        for(int neighbour : adj.get(i)) {
            if(visited[neighbour] == 1 && pathVisited[neighbour] == 1) {
                return true;
            }
            
            else if(visited[neighbour] == 0) {
                if(dfs(neighbour, visited, pathVisited, stack, adj)) {
                    return true;
                }
            }
        }
        
        stack.push(i);
        pathVisited[i] = 0;
        
        return false;
    }
    
    
}