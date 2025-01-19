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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int row, col, pathLength;
    Pair(int row, int col, int pathLength) {
        this.row = row;
        this.col = col;
        this.pathLength = pathLength;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1; 
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(source[0], source[1], 0));
        visited[source[0]][source[1]] = true;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!queue.isEmpty()) {
            int currRow = queue.peek().row;
            int currCol = queue.peek().col;
            int currPathLen = queue.peek().pathLength;
            queue.poll();
            
            if(currRow == destination[0] && currCol == destination[1]) return currPathLen;
            
            for(int[] neighbour : directions) {
                int newRow = currRow + neighbour[0];
                int newCol = currCol + neighbour[1];
                
                if(0 <= newRow && newRow < n && 0 <= newCol && newCol < m && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    visited[newRow][newCol] = true;
                    queue.offer(new Pair(newRow, newCol, currPathLen + 1));
                }
            }
        }
        
        return -1;
    }
}
