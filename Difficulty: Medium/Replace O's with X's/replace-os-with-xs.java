//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static char[][] fill(char mat[][]) {
        // code here
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[mat.length][mat[0].length];
        int n = mat.length;
        int m = mat[0].length;
        
        for(int j = 0; j < m; j++) {
            // firstRow
            if(mat[0][j] == 'O' && visited[0][j] == 0) {
                dfs(0, j, visited, directions, mat);
            }
            
            // last Row
            if(mat[n - 1][j] == 'O' && visited[n - 1][j] == 0) {
                dfs(n - 1, j, visited, directions, mat);
            }
        }
        
        for(int i = 0; i < n; i++) {
            // first Column
            if(mat[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, visited, directions, mat);
            }
            
            // last Column
            if(mat[i][m - 1] == 'O' && visited[i][m - 1] == 0) {
                dfs(i, m - 1, visited, directions, mat);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 'O' && visited[i][j] == 0){
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
        
    }
    
    private static void dfs(int row, int col, int[][] visited, int[][] directions, char[][] mat) {
        visited[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if(0 <= newRow && newRow < n && 0 <= newCol && newCol < m && visited[newRow][newCol] == 0 && mat[newRow][newCol] == 'O') {
                dfs(newRow, newCol, visited, directions, mat);
            }
        }
        
    }
}