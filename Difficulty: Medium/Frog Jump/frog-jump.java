//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// Top Down Approach

// class Solution {
//     int minCost(int[] height) {
//         // code here
//         int[] dp = new int[height.length];
//         for(int i = 0; i < dp.length; i++) {
//             dp[i] = -1;
//         }
        
//         int result = helper(height.length - 1, height, dp);
        
//         return result;
//     }
    
//     private int helper(int i, int[] height, int[] dp) {
//         if(i == 0) {
//             return 0;
//         }
        
//         if(dp[i] != -1) {
//             return dp[i];
//         }
        
//         int left = helper(i - 1, height, dp) + Math.abs(height[i] - height[i - 1]);
//         int right = Integer.MAX_VALUE;
//         if(i > 1) {
//             right = helper(i - 2, height, dp) + Math.abs(height[i] - height[i - 2]); 
//         }
        
//         return dp[i] = Math.min(left, right);
//     }
// }



// Using Bottom Up Approach

// class Solution {
//     int minCost(int[] height) {
//         // code here
//         int[] dp = new int[height.length];
//         dp[0] = 0;
        
//         for(int i = 1; i < dp.length; i++) {
//             int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
//             int right = Integer.MAX_VALUE;
//             if(i > 1) {
//                 right = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
//             }
//             dp[i] = Math.min(left, right);
//         }
        
//         return dp[dp.length - 1];
//     }
// }



// Using Most Optimal Approach

class Solution {
    int minCost(int[] height) {
        // code here
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i = 1; i < height.length; i++) {
            int first = prev1 + Math.abs(height[i] - height[i - 1]);
            int second = Integer.MAX_VALUE;
            if(i > 1) {
                second = prev2 + Math.abs(height[i] - height[i - 2]);
            }
            int curr = Math.min(first, second);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends