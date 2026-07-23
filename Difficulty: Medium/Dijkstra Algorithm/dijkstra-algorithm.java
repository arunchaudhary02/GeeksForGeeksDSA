/*
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];
            
            adjList.get(node1).add(new int[]{node2, weight});
            adjList.get(node2).add(new int[]{node1, weight});
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[src] = 0;
        
        // {weight, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, src});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            int d = curr[0];
            int node = curr[1];
            
            if(distance[node] < d) continue;
            
            for(int[] neighbour : adjList.get(node)) {
                int adjNode = neighbour[0];
                int weight = neighbour[1];
                
                if(d + weight < distance[adjNode]) {
                    distance[adjNode] = d + weight;
                    pq.offer(new int[]{d + weight, adjNode});
                }
            }
        }
        
        return distance;
    }
}
*/

// Better Approach using TreeSet


class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];
            
            adjList.get(node1).add(new int[]{node2, weight});
            adjList.get(node2).add(new int[]{node1, weight});
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[src] = 0;
        
        // {weight, node}
        TreeSet<int []> set = new TreeSet<>((a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        set.add(new int[]{0, src});
        
        while(!set.isEmpty()) {
            int[] curr = set.pollFirst();
            
            int d = curr[0];
            int node = curr[1];
            
            for(int[] neighbour : adjList.get(node)) {
                int adjNode = neighbour[0];
                int weight = neighbour[1];
                
                if(d + weight < distance[adjNode]) {
                     // Remove old entry if it exists
                    if (distance[adjNode] != Integer.MAX_VALUE) {
                        set.remove(new int[]{distance[adjNode], adjNode});
                    }

                    distance[adjNode] = d + weight;

                    set.add(new int[]{distance[adjNode], adjNode});
                }
            }
        }
        
        return distance;
    }
}


