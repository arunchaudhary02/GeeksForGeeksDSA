class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        int infinite = 100000000;
        
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][via] == infinite || dist[via][j] == infinite) {
                        continue;
                    }
                    
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
    }
}