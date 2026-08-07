class Solution {
    private static int[] parent;
    private static int[] rank;
    
    private static int findParent(int x) {
        if(x == parent[x]) return x;
        
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
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        parent = new int[V];
        rank = new int[V];
        
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        for(int u = 0; u < V; u++) {
            for(int v : adj.get(u)) {
                if(u < v) {
                    if(findParent(u) == findParent((v))) {
                        return true;
                    }
                    else {
                        union(u, v);
                    }
                }
            }
        }
        
        return false;
    }
}