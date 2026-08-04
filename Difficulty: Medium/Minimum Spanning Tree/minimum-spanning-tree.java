class Solution {
    
    static class Pair {
        int weight;
        int node;
        
        Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2]; 
            
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.add(new Pair(0, 0));
        
        int sum = 0;
        
        boolean[] inMst = new boolean[V];
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currW = curr.weight;
            int currNode = curr.node;
            
            if(inMst[currNode]) {
                continue;
            }
            inMst[currNode] = true;
            sum += currW;
            
            for (int[] neighbour : adjList.get(currNode)) {
                int nextNode = neighbour[0];
                int nextW = neighbour[1];
                
                if (!inMst[nextNode]) {
                    pq.add(new Pair(nextW, nextNode));
                }
            }
            
        }
        
        return sum;
    }
}
