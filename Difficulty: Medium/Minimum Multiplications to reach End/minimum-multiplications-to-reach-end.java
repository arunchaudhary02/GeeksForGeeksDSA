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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
       
        // Your code here
        if (start == end) return 0;

        int MOD = 100000;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MOD];

        // Start BFS with the initial state
        queue.add(new int[]{start, 0}); // {current value, steps taken}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            // Explore all possible next states
            for (int num : arr) {
                int nextValue = (value * num) % MOD;

                // If end is reached, return the steps
                if (nextValue == end) {
                    return steps + 1;
                }

                // If not visited, add to the queue
                if (!visited[nextValue]) {
                    visited[nextValue] = true;
                    queue.add(new int[]{nextValue, steps + 1});
                }
            }
        }

        // If we exhaust the queue and don't find the end
        return -1;
    }
}
