// User function Template for Java

class Solution {
    public char nthCharacter(String s, int r, int n) {
        // code here
        
        String tempS = new String(s);
        
        for(int i = 0; i < r; i++) {
            StringBuilder str = new StringBuilder();
            
           for(int j = 0; j < tempS.length(); j++) {
                char ch = tempS.charAt(j);
                if(str.length() > n) {
                    break;
                }
                if(ch == '0') {
                    str.append("01");
                }
                else {
                    str.append("10");
                }
            }
            
            tempS = str.toString();
        }
        
        return tempS.charAt(n);
    }
}