//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                if(dfsCheck(i, visited, pathVisited, adj) == true) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    private boolean dfsCheck(int node, int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        pathVisited[node] = 1;
        
        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                if(dfsCheck(it, visited, pathVisited, adj) == true) {
                    return true;
                }
            }
            else if(pathVisited[it] == 1) {
                return true;
            }
        }
        
        pathVisited[node] = 0;
        return false;
    }
}