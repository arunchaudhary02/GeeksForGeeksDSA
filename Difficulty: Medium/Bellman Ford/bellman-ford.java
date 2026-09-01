class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                }
            }
        }

        // Check negative cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(-1);
                return result;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dis) {
            result.add(d == Integer.MAX_VALUE ? (int)1e8 : d);
        }

        return result;
    }
}