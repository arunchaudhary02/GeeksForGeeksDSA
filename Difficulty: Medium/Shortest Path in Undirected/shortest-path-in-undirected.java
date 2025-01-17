//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        boolean[] visited = new boolean[n];
        visited[src] = true;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            for(int neighbour : adj.get(currNode)) {
                if(!visited[neighbour]) {
                    if(distance[currNode] + 1 < distance[neighbour]) {
                        distance[neighbour] = distance[currNode] + 1;
                        visited[neighbour] = true;
                        queue.add(neighbour);
                    }
                }
                
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        
        return distance;
    }
}
