class Solution {
    public static boolean checkPangram(String s) {
        // code here
        
        s = s.toLowerCase();
        
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()) {
            if('a' <= c && c <= 'z') {
                freq[c - 'a']++;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) {
                return false;
            }
        }
        
        return true;
    }
}