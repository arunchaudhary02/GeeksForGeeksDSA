// User function Template for Java

// Brute Force

/*

class Solution {
    int isRotatedPalindrome(String s) {
        // Your Code Here
        StringBuilder str = new StringBuilder(s);
        
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            
            String original = str.toString();
            String reverseStr = new StringBuilder(original).reverse().toString();
            if(original.equals(reverseStr)) {
                return 1;
            }
            
            char c = str.charAt(0);
            str.deleteCharAt(0);
            str.append(c);
            
        }
        
        return 0;
    }
    
}

*/

class Solution {
    int isRotatedPalindrome(String s) {
        
        int n = s.length();
        String doubleStr = s + s;
        
        for(int i = 0; i < n; i++) {
            String str = doubleStr.substring(i, n + i);
            if(isPalindrome(str)) {
                return 1;
            }
        }
        
        return 0;
    }
    
    private boolean isPalindrome(String str) {
        
        int L = 0, R = str.length() - 1;
        
        while(L <= R) {
            if(str.charAt(L) != str.charAt(R)) {
                return false;
            }
            L++;
            R--;
        }
        
        return true;
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        