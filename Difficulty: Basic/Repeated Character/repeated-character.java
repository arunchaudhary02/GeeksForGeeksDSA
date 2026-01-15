// User function Template for Java
class Solution {
    char firstRep(String S) {
        // your code here
        int[] freq = new int[26];
        
        for(char c : S.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for(char c : S.toCharArray()) {
            if(freq[c - 'a'] > 1) {
                return c;
            }
        }
        
        return '#';
    }
}