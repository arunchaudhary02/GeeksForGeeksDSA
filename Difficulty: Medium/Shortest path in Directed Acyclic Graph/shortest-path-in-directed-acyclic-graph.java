//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Pair {
    int destinationVertex, weight;
    Pair(int destinationVertex, int weight) {
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }
}

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];
            adj.get(source).add(new Pair(destination, weight));
        }

        // Perform topological sort
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topologicalSort(i, adj, visited, stack);
            }
        }

        // Initialize distance array
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (distance[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (distance[node] + p.weight < distance[p.destinationVertex]) {
                        distance[p.destinationVertex] = distance[node] + p.weight;
                    }
                }
            }
        }

        // Update distance array to replace Integer.MAX_VALUE with -1 for unreachable vertices
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private void topologicalSort(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for (Pair p : adj.get(node)) {
            if (visited[p.destinationVertex] == 0) {
                topologicalSort(p.destinationVertex, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}

























