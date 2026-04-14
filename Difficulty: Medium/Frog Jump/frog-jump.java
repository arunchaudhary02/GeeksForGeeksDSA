//. Approach-1 (Using Bottom Up DP)

/*
class Solution {
    int minCost(int[] height) {
        // code here
        
        int n = height.length;
        
        int[] dp = new int[n];
        
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);
        
        for(int i = 2; i < n; i++) {
            int oneStep = dp[i - 1] + (Math.abs(height[i] - height[i - 1]));
            int twoStep = dp[i - 2] + (Math.abs(height[i] - height[i - 2]));
            
            dp[i] = Math.min(oneStep, twoStep);
        }
        
        return dp[n - 1];
    }
}

*/

// Approach 2 Recursion + DP

class Solution {
    int minCost(int[] height) {
        
        int n = height.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return recursion(n - 1, height, dp);
    }
    
    private int recursion(int index, int[] height, int[] dp) {
        
        if(index == 0) {
            return 0;
        }
        
        if(index == 1) {
            return Math.abs(height[1] - height[0]);
        }
        
        if(dp[index] != -1) {
            return dp[index];
        }
        
        
        int left = recursion(index - 1, height, dp)
                + Math.abs(height[index] - height[index - 1]);
        
        
        int right = recursion(index - 2, height, dp)
                + Math.abs(height[index] - height[index - 2]);
        
        dp[index] = Math.min(left, right);
        
        return dp[index];
        
    }
}


// Using Most Optimal Approach

/*
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

*/