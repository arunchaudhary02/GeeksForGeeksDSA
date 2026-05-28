// Brute Force Approach

/*
class Solution {
    public String getLongestPal(String s) {
        // code here
        
        String result = "";
        
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++) {
                if(isSubstring(s, i, j)){
                    if(result.length() < j - i + 1) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isSubstring(String s, int low, int high) {
        if(low >= high) {
            return true;
        }
        
        if(s.charAt(low) == s.charAt(high)) {
            return isSubstring(s, low + 1, high - 1);
        }
        else {
            return false;
        }
    }
}
*/


class Solution {
    
    int[][] memo;
    
    public String getLongestPal(String s) {
        // code here
        
        int len = s.length();
        memo = new int[len][len];
        
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        int startIndex = 0;
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(isSubstring(s, i, j)) {
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        
        return s.substring(startIndex, startIndex + maxLen);
    }
    
    private boolean isSubstring(String s, int low, int high) {
        if(low >= high) {
            return true;
        }
        
        if(memo[low][high] != -1) {
            return memo[low][high] == 1;
        }
        
        if(s.charAt(low) == s.charAt(high)) {
            memo[low][high] = isSubstring(s, low + 1, high - 1) ? 1 : 0;
        }
        else{
            memo[low][high] = 0;
        }
        
        return memo[low][high] == 1;
    }
}
