class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        
        Map<Character, Integer> map = new HashMap<>();
        
        int longest = -1;
        
        int L = 0, R = 0;
        
        while(R < s.length()) {
            
            map.put(s.charAt(R), map.getOrDefault(s.charAt(R), 0) + 1);
            
            while(map.size() > k) {
                map.put(s.charAt(L), map.get(s.charAt(L)) - 1);
                if(map.get(s.charAt(L)) == 0) {
                    map.remove(s.charAt(L));
                }
                
                L++;
            }
            
            if(map.size() == k) {
                longest = Math.max(longest, R - L + 1);
            }
            
            R++;
        }
        
        return longest;
    }
}