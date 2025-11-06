// User function Template for Java

class Solution {
    public String removeConsecutiveCharacter(String s) {
        // code here
        
        if(s.length() == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++) {
            if(result.charAt(result.length() - 1) != s.charAt(i)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
        
    }
}