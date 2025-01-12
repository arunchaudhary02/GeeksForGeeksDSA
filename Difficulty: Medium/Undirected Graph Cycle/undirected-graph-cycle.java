//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    
    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i < vertices; i++) visited[i] = false;
        
        for(int i = 0; i < vertices; i++) {
            if(visited[i] == false) {
                if(checkForCycle(i, vertices, visited, adj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean checkForCycle(int src, int vertices, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        
        while(!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();
            
            for(int adjacentNode : adj.get(node)) {
                if(visited[adjacentNode] == false) {
                    visited[adjacentNode] = true;
                    queue.add(new Pair(adjacentNode, node));
                }
                else if(parent != adjacentNode) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    
    
}