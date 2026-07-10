//Iterative DFS

/*

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        
        while(!stack.isEmpty()) {
            int currNode = stack.pop();
            result.add(currNode);
            
            for(int neighbour : adj.get(currNode)) {
                if(visited[neighbour] == false) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
        
        return result;
    }
}
*/


// Recursive DFS

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        
        dfsHelper(0, adj, visited, result);
        
        return result;
    }
    
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        
        visited[node] = true;
        result.add(node);
        
        for(int neighbour : adj.get(node)) {
            if(visited[neighbour] == false) {
                dfsHelper(neighbour, adj, visited, result);
            }
        }
    }
}




















