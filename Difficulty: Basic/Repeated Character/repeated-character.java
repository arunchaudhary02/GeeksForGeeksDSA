// User function Template for Java
class Solution {
    char firstRep(String S) {
        // your code here
        
        int[] count = new int[26];
        
        for(char c : S.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(char c : S.toCharArray()) {
            int index = c - 'a';
            if(count[index] > 1) {
                return c;
            }
        }
        
        return '#';
    }
}