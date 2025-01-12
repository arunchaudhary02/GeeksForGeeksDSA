//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static class Pair{
        int rowIndex, colIndex;
        Pair(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int totalRow = grid.length;
        int totalCol = grid[0].length;
        int[][] visited = new int[totalRow][totalCol];
        
        Queue<Pair> queue = new LinkedList<>();
        
        // Check first and last columns
        for(int i = 0; i < totalRow; i++) {
            // first Column
            if(grid[i][0] == 1 && visited[i][0] == 0) {
                queue.add(new Pair(i, 0));
                visited[i][0] = 1;
            }
            
            // last Column
            if(grid[i][totalCol - 1] == 1 && visited[i][totalCol - 1] == 0) {
                queue.add(new Pair(i, totalCol - 1));
                visited[i][totalCol - 1] = 1;
            }
        }
        // Check first and last rows
        for(int j = 0; j < totalCol; j++) {
            // first Row
            if(grid[0][j] == 1 && visited[0][j] == 0) {
                queue.add(new Pair(0, j));
                visited[0][j] = 1;
            }
            
            //last row
            if(grid[totalRow - 1][j] == 1 && visited[totalRow - 1][j] == 0) {
                queue.add(new Pair(totalRow - 1, j));
                visited[totalRow - 1][j] = 1;
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int currRow = queue.peek().rowIndex;
            int currCol = queue.peek().colIndex;
            queue.remove();
            visited[currRow][currCol] = 1;
            for(int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
                
                if(0 <= newRow && newRow < totalRow && 0 <= newCol && newCol < totalCol && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
        
        
        int count = 0;
        for(int i = 0; i < totalRow; i++) {
            for(int j = 0; j < totalCol; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}