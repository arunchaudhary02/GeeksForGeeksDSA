//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair {
    int node, cost;
    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Tuple {
    int stop, node, cost;
    Tuple(int stop, int node, int cost) {
        this.stop = stop;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        while(!queue.isEmpty()) {
            Tuple it = queue.poll();
            int stops = it.stop;
            int currNode = it.node;
            int currCost = it.cost;
            
            if(stops > k) continue;
            
            for(Pair neightbour : adj.get(currNode)) {
                int adjNode = neightbour.node;
                int adjCost = neightbour.cost;
                
                if(currCost + adjCost < distance[adjNode] && stops <= k){
                    distance[adjNode] = currCost + adjCost;
                    queue.add(new Tuple(stops + 1, adjNode, currCost + adjCost));
                }
            }
        }
        
        if(distance[dst] == Integer.MAX_VALUE) return -1;
        return distance[dst];
    }
}