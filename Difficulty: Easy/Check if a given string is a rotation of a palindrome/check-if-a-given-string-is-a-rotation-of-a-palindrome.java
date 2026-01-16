// User function Template for Java

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