// Using DSU

class Solution {
    private static int[] parent;
    private static int[] rank;
    
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        
        parent = new int[V];
        rank = new int[V];
        
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(edges, (a, b) -> (a[2] - b[2]));
        
        int mstWeight = 0;
        int edgesCount = 0;
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            if(findParent(u) != findParent(v)) {
                union(u, v);
                mstWeight += weight;
                edgesCount++;
                
                if(edgesCount == V - 1) break;
            }
        }
        
        return mstWeight;
    }
    
    private static int findParent(int x) {
        if(x == parent[x]) {
            return x;
        }
        
        return findParent(parent[x]);
    }
    
    private static void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        
        if(xParent == yParent) return;
        
        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        else if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }
        else{
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
