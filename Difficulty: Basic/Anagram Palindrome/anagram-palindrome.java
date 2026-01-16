class Sol {
    int isPossible(String s) {
        // your code here
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int countOdd = 0;
        
        for(int value : map.values()) {
            if(value % 2 != 0) {
                countOdd++;
            }
        }
        
        if(countOdd > 1) {
            return 0;
        }
        return 1;
    }
}