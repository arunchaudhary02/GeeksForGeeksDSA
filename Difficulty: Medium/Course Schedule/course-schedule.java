//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        
System.out.println("~");
}
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(ArrayList<Integer> innerList : prerequisites) {
            adj.computeIfAbsent(innerList.get(0), k -> new ArrayList<>()).add(innerList.get(1));
        }
        
        List<Integer> output = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        
        for(int course = 0; course < n; course++) {
            if(!dfs(course, adj, visited, cycle, output)) {
                return new int[0];
            }
        }
        
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = output.get(i);
        }
        
        return result;
    } 
    
    private static boolean dfs(int course, Map<Integer, List<Integer>> adj, Set<Integer> visited, Set<Integer> cycle, List<Integer> output) {
        if(cycle.contains(course)) return false;
        
        if(visited.contains(course)) return true;
        
        cycle.add(course);
        
        for(int neighbour : adj.getOrDefault(course, new ArrayList<>() )) {
            if(!dfs(neighbour, adj, visited, cycle, output)) {
                return false;
            }
        }
        
        cycle.remove(course);
        visited.add(course);
        output.add(course);
        
        return true;
    }
}