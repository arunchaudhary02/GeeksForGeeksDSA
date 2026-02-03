class Solution {
    public long countSub(String str) {
        int n = str.length();
        int openCount = 0;
        int closeCount = 0;
        
        // count total closing brackets
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ')') {
                closeCount++;
            }
        }
        
        int ans = -1;
        
        // ✅ check index 0 (empty left part)
        if (openCount == closeCount) {
            ans = 0;
        }
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                openCount++;
            }
            if (str.charAt(i) == ')') {
                closeCount--;
            }
            
            if (openCount == closeCount) {
                ans = i + 1;
            }
        }
        
        return ans;
    }
}
