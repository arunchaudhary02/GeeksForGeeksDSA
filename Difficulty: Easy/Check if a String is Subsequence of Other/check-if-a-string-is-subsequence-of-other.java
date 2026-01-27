class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        if(n == 0) {
            return true;
        }
        if(m == 0) {
            return false;
        }
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == n;
    }
};