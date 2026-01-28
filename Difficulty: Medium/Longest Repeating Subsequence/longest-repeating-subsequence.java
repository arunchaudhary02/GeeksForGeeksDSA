// User function Template for Java

class Solution {
    
    int[][] memo;
    int n;

    public int LongestRepeatingSubsequence(String s) {

        n = s.length();
        memo = new int[n][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, 0);
    }

    private int solve(String s, int i, int j) {

        if (i == n || j == n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // match but indices must be different
        if (s.charAt(i) == s.charAt(j) && i != j) {
            memo[i][j] = 1 + solve(s, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(
                solve(s, i + 1, j),
                solve(s, i, j + 1)
            );
        }

        return memo[i][j];
    }
}