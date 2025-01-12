//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    ArrayList<String> islandShape = new ArrayList<>();
                    dfs(i, j, visited, grid, islandShape, directions, i, j);
                    set.add(islandShape);
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int row, int col, int[][] visited, int[][] grid, ArrayList<String> islandShape, int[][] directions, int row0, int col0) {
        visited[row][col] = 1;
        islandShape.add(toString(row - row0, col - col0));
        
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if(0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, visited, grid, islandShape, directions, row0, col0);
            }
        }
        
    }
    
    private String toString(int row, int col) {
        return Integer.toString(row) + "|" + Integer.toString(col);
    }
}
