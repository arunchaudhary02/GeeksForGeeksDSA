class Solution {
    public static int sumSubstrings(String s) {
        // code here
        
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            StringBuilder curr = new StringBuilder();
            
            for(int j = i; j < s.length(); j++) {
                curr.append(s.charAt(j));
                result += Integer.parseInt(curr.toString());
            }
        }
        
        return result;
    }
    
    
}