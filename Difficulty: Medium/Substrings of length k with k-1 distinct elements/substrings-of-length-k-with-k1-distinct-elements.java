class Solution {
    public int substrCount(String s, int k) {
        // code here
        
        int result = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            while((right - left + 1) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                
                left++;
            }
            
            if((right - left + 1) == k && map.size() == k - 1) {
                result++;
            }
        }
        
        return result;
    }
}