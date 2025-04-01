//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        if(mat.get(0).get(0) == 0 || mat.get(mat.size() - 1).get(mat.size() - 1) == 0) {
            return result;
        }
        int len = mat.size();
        getAllPath(mat, 0, 0, len, result, "");
        
        return result;
        
    }
    
    private void getAllPath(ArrayList<ArrayList<Integer>> mat, int row, int col, int len, ArrayList<String> result, String currStr) {
        
        if(row >= len || row < 0 || col >= len || col < 0 || mat.get(row).get(col) == 0){
            return;
        }
        
        
        if(row == len - 1 && col == len - 1) {
            result.add(currStr);
            return;
        }
        
        mat.get(row).set(col, 0);
        
        getAllPath(mat, row + 1, col, len, result, currStr + "D");
        getAllPath(mat, row, col - 1, len, result, currStr + "L");
        getAllPath(mat, row, col + 1, len, result, currStr + "R");
        getAllPath(mat, row - 1, col, len, result, currStr + "U");
        
        
        mat.get(row).set(col, 1);
        
        
        
    }
}