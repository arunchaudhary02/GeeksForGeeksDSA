//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int vertices = Integer.parseInt(read.readLine());
            int edges = Integer.parseInt(read.readLine());

            for (int i = 0; i < vertices; i++) adj.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edges; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
            }

            ArrayList<Integer> res = new Solution().topologicalSort(adj);

            if (check(adj, vertices, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends




//=>    By DFS //////////////////////////////////////

// class Solution {
//     // Function to return list containing vertices in Topological order.
//     static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
//         // Array to keep track of visited nodes
//         boolean[] visited = new boolean[adj.size()];

//         // Stack to store the topological order
//         Stack<Integer> stack = new Stack<>();

//         // Perform DFS for each node that has not been visited
//         for (int i = 0; i < visited.length; i++) {
//             if (!visited[i]) {
//                 // Call DFS to process the node and its neighbors
//                 dfs(i, visited, stack, adj);
//             }
//         }

//         // Create a list to store the topological order
//         ArrayList<Integer> topologicalOrder = new ArrayList<>();
//         // Pop elements from the stack to get the topological order
//         while (!stack.isEmpty()) {
//             topologicalOrder.add(stack.pop());
//         }

//         // Return the topological order
//         return topologicalOrder;
//     }

//     // Helper method to perform DFS on the graph
//     private static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
//         // Mark the current node as visited
//         visited[node] = true;

//         // Iterate over all neighbors of the current node
//         for (int neighbor : adj.get(node)) {
//             // If the neighbor has not been visited, perform DFS on it
//             if (!visited[neighbor]) {
//                 dfs(neighbor, visited, stack, adj);
//             }
//         }

//         // After visiting all neighbors, push the current node onto the stack
//         stack.push(node);
//     }
// }


//=>.   By BFS (Khan's Algorithms) /////////////////////////////


class Solution {
    // Function to return a list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[adj.size()]; // Array to store the in-degree of each vertex
        
        // Calculate in-degree for each vertex
        for (int i = 0; i < adj.size(); i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++; // Increment in-degree for each outgoing edge
            }
        }

        // Queue to manage vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();

        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); // Add vertex to the queue if it has no dependencies
            }
        }

        // List to store the topological order
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        
        // Process the vertices in the queue
        while (!queue.isEmpty()) {
            int currNode = queue.poll(); // Remove vertex from the queue
            topologicalOrder.add(currNode); // Add it to the topological order
            
            // Reduce the in-degree of its neighbors
            for (int neighbour : adj.get(currNode)) {
                indegree[neighbour]--; // Decrease in-degree by 1
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour); // If in-degree becomes 0, add to queue
                }
            }
        }

        return topologicalOrder; // Return the topological order
    }
}




















