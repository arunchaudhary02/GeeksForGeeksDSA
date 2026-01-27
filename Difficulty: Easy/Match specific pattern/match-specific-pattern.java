/*Complete the provided function*/

class GfG {
    /* The function returns an array of strings
    present in the dictionary which matches
    the string pattern.
    You are required to complete this method */
    public static ArrayList<String> findMatchedWords(int n, ArrayList<String> dict,
                                                     String pattern) {
       
        
        int len = pattern.length();
        String hashPattern = encodeString(pattern);
        ArrayList<String> result = new ArrayList<>();
        
        for(String word : dict) {
            if(word.length() == len && (encodeString(word).equals(hashPattern))) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    
     // Function to encode given string
     
    private static String encodeString(String str) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        StringBuilder hashResult = new StringBuilder();
        int number = 1;
        
        for(char ch : str.toCharArray()) {
            if(!map.containsKey(ch)) {
                map.put(ch, number);
                number++;
            }
            
            hashResult.append(map.get(ch));
        }
        
        return hashResult.toString();
    }
}