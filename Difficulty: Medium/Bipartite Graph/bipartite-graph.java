//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            S = br.readLine().trim().split(" ");
            int E = Integer.parseInt(S[0]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(adj);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Initialize color array with -1 for all nodes (indicating unvisited)
        int[] color = new int[adj.size()];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        
        // Check each node to see if the graph is bipartite
        for (int i = 0; i < color.length; i++) {
            // If the node is unvisited, perform DFS
            if (color[i] == -1) {
                // If DFS returns false, the graph is not bipartite
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        
        // If all nodes are properly colored, the graph is bipartite
        return true;
    }
    
    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        // Color the current node
        color[node] = col;
        
        // Traverse the adjacent nodes
        for (int it : adj.get(node)) {
            // If the adjacent node is unvisited, perform DFS on it
            if (color[it] == -1) {
                // Alternate the color for the adjacent node and check recursively
                if (!dfs(it, 1 - col, color, adj)) {
                    return false;
                }
            }
            // If the adjacent node has the same color, the graph is not bipartite
            else if (color[it] == col) {
                return false;
            }
        }
        
        // Return true if no conflicts are found
        return true;
    }
}
