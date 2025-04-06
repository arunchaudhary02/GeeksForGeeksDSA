//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }
        }
        
        return count;
    }
    
    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        for(int j = 0; j < adj.get(node).size(); j++) {
            if(adj.get(node).get(j) == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, visited, adj);
            }
        }
    }
}