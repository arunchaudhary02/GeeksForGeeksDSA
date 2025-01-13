//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
       // Your code here
       int[] visited = new int[V];
       int[] pathVisited = new int[V];
       int[] check = new int[V];
       
       for(int i = 0; i < V; i++) {
           if(visited[i] == 0) {
               dfsCheck(i, adj, visited, pathVisited, check);
           }
       }
       
       List<Integer> safeNodes = new ArrayList<>();
       for(int i = 0; i < check.length; i++) {
           if(check[i] == 1) {
               safeNodes.add(i);
           }
       }
       
       return safeNodes;
    }
    
    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] visited, int[] pathVisited, int[] check) {
        visited[node] = 1;
        pathVisited[node] = 1;
        check[node] = 0;
        
        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                if(dfsCheck(it, adj, visited, pathVisited, check)) {
                    return true;
                }
            }
            else if(pathVisited[it] == 1) {
                    return true;
            }
        }
        
        check[node] = 1;
        pathVisited[node] = 0;
        return false;
    }
}
