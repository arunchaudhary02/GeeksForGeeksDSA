
class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                // Important check to avoid overflow
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(-1);
                return ans;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) {
            result.add(d == Integer.MAX_VALUE ? (int)1e8 : d);
        }

        return result;
    }
}