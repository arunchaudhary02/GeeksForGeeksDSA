class Solution {
    static int lcs(String s1, String s2) {
        // code here
        
        int m = s1.length();
        int n = s2.length();
        
        int[][] memo = new int[m + 1][n + 1];
        
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        return lcsHelper(s1, s2, m, n, memo);
    }
    
    static int lcsHelper(String s1, String s2, int m, int n, int[][] memo) {
        if(n == 0 || m == 0) {
            return 0;
        }
        
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        
        if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
             memo[m][n] =  1 + lcsHelper(s1, s2, m - 1, n - 1, memo);
        }
        else {
            memo[m][n] =  Math.max(lcsHelper(s1, s2, m - 1, n, memo), lcsHelper(s1, s2, m, n - 1, memo));
        }
        
        return memo[m][n];

    }
}