class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> bfsResult = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            Integer currNode = queue.poll();
            bfsResult.add(currNode);
            
            for(int neighbour : adj.get(currNode)) {
                if(visited[neighbour] == false) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        
        return bfsResult;
    }
}