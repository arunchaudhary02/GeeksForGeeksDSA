public class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbour : adj.get(curr)) {
                if (distance[neighbour] > distance[curr] + 1) {
                    distance[neighbour] = distance[curr] + 1;
                    queue.offer(neighbour);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}
