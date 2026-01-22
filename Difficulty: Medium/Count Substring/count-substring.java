class Solution {
    public static int countSubstring(String s) {
        // code here
        
        int n = s.length();
        int[] freq = new int[3]; // for a, b, c
        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            // while window contains at least one a, b, c
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // all substrings ending at 'right' are valid
                count += (n - right);

                // shrink from left
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}
