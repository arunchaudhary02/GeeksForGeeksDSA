//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Node {
    int rowIndex, colIndex, steps;
    public Node(int rowIndex, int colIndex, int steps) {
        this.rowIndex= rowIndex;
        this.colIndex = colIndex;
        this.steps = steps;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] resultDistance = new int[row][col];
        int[][] visited = new int[row][col];
        Queue<Node> queue = new LinkedList<>();
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
                else {
                    visited[i][j] = 0;
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!queue.isEmpty()) {
            int currRow = queue.peek().rowIndex;
            int currCol = queue.peek().colIndex;
            int steps = queue.peek().steps;
            queue.remove();
            resultDistance[currRow][currCol] = steps;
            for(int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
                if(0 <= newRow && newRow < row && 0 <= newCol && newCol < col && visited[newRow][newCol] == 0 ) {
                    visited[newRow][newCol] = 1;
                    queue.offer(new Node(newRow, newCol, steps + 1));
                }
            }
            
        }
        
        return resultDistance;
        
        
    }
}