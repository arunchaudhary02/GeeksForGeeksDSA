class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split("\\."); // split by dot
        StringBuilder result = new StringBuilder();

        // iterate in reverse
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) { // skip empty strings
                if (result.length() > 0) {
                    result.append(".");
                }
                result.append(words[i]);
            }
        }

        return result.toString();
    }
}
