// User function Template for Java

class Solution {
    boolean isSubSequence(String A, String B) {
        
        int n = A.length();
        int m = B.length();
        
        if(n == 0) {
            return true;
        }
        if(m == 0) {
            return false;
        }
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if(A.charAt(i) == B.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == n;
    }
}