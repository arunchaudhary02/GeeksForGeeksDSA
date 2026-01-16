class Solution {
    public boolean isPalinSent(String s) {
        // code here
        
        if(s.isEmpty()) {
            return false;
        }
        
        s = s.toLowerCase();
        
        StringBuilder str = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(isLetter(c)) {
                str.append(c);
            }
        }
        
        String original = str.toString();
        // String reverseStr = str.reverse().toString();
        String reverseStr = new StringBuilder(original).reverse().toString();
        
        return original.equals(reverseStr);
    }
    
    private boolean isLetter(char c) {
        if(('a' <= c && c <= 'z' ) || ('0' <= c && c <= '9')) {
            return true;
        }
        return false;
    }
}