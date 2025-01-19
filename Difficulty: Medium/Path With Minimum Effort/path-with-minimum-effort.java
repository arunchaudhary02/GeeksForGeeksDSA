//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Tuple {
    int distance, row, col;
    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public static int MinimumEffort(int rows, int cols, int[][] heights) {
        // code here
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        int[][] distance = new int[rows][cols];
        for(int[] rowArr : distance) {
            Arrays.fill(rowArr, Integer.MAX_VALUE);
        }
        
        distance[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(pq.size() != 0) {
            Tuple currIt = pq.poll();
            int diff = currIt.distance;
            int currRow = currIt.row;
            int currCol = currIt.col;
            
            if(currRow == rows - 1 && currCol == cols - 1) {
                return diff;
            }
            
            for(int[] neighbour : directions) {
                int newRow = currRow + neighbour[0];
                int newCol = currCol + neighbour[1];
                
                if(0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols) {
                    int newEffort = Math.max(Math.abs(heights[currRow][currCol] - heights[newRow][newCol]), diff);
                    if(newEffort < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newEffort;
                        pq.add(new Tuple(newEffort, newRow, newCol));
                    }
                }
            }
        }
        
        return 0;
    }
}
