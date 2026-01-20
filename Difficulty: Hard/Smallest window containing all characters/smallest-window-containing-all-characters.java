class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        
        if(p.isEmpty()) {
            return "";
        }
        
        
        int[] freq = new int[256];
        
        for(char c : p.toCharArray()) {
            freq[c]++;
        }
        
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        
        int L = 0;
        for(int R = 0; R < s.length(); R++) {
            char currentLetter = s.charAt(R);
            if(freq[currentLetter] > 0) {
                count++;
            }
            freq[currentLetter]--;
            
            while(count == p.length()) {
                if(R - L + 1 < minLen) {
                    minLen = R - L + 1;
                    startIndex = L;
                }
                
                freq[s.charAt(L)]++;
                if(freq[s.charAt(L)] > 0) {
                    count--;
                }
                L++;
            }
        }
        
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
        
    }
}