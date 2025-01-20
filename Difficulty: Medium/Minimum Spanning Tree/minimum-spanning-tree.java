//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// Prim's Algorithm - Minimum Spanning Tree
class Pair {
    int node, distance;
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        boolean[] visited = new boolean[V];
        
        pq.add(new Pair(0, 0));
        int sum = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currWeight = curr.distance;
            
            if(visited[currNode]) continue;
            
            visited[currNode] = true;
            sum += currWeight;
            
            for(int[] neighbour : adj.get(currNode)) { //  NextNode = neighbour[0],  weight = neighbour[1]
                int nextNode = neighbour[0];
                int weight = neighbour[1];
                
                if (!visited[nextNode]) {
                    pq.add(new Pair(nextNode, weight));
                }
            }
            
        }
        
        return sum;
        
    }
}