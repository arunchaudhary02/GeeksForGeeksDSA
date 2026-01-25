class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        
        // Condition 1: length must be same
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequency of characters
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int changesNeeded = 0;

        // Count extra characters in s1
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > freq2[i]) {
                changesNeeded += freq1[i] - freq2[i];
            }
        }

        return changesNeeded <= k;
    }
}