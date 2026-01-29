class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return helper(s1, s2, m, n, dp);
    }
    
    private static int helper(String s1, String s2, int m, int n, int[][] dp) {
        
        // If s1 is empty, take all of s2
        if(n == 0) {
            return m;
        }
        
        // If s2 is empty, take all of s1
        if(m == 0) {
            return n;
        }
        
         // check before solve the subproblem
         if(dp[m][n] != -1) {
             return dp[m][n];
         }
        
        // If last chars match, include once
        if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + helper(s1, s2, m - 1, n - 1, dp);
        }
        
        // If not match, try both options and take min
        // and store it in dp array
        return dp[m][n] =  1 + Math.min((helper(s1, s2, m - 1, n, dp)), (helper(s1, s2, m, n - 1, dp)));
        
    }
}