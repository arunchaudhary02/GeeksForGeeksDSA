// User function Template for Java
class Solution {
    public int countWays(String digits) {
        // code here
        int n = digits.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        return decodeHelper(digits, 0, memo);
        
    }
    
    private int decodeHelper(String digits, int index, int[] memo) {
        int n = digits.length();
        
        if(index >= n) {
            return 1;
        }
        
        if(memo[index] != -1) {
            return memo[index];
        }
        
        int ways = 0;
        
        if(digits.charAt(index) != '0') {
            ways = decodeHelper(digits, index + 1, memo);
        }
        
        if(index + 1 < n && 
            (
                digits.charAt(index) == '1' || 
                (digits.charAt(index) == '2' && digits.charAt(index + 1) <= '6')
            )
        ){
            ways += decodeHelper(digits, index + 2, memo);
        }
        
        memo[index] = ways;
        
        return ways;
    }
}