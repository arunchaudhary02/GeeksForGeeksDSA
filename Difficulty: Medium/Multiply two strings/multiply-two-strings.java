class Solution {
    public String multiplyStrings(String s1, String s2) {
        
        // Handle sign
        boolean negative = false;
        
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }
        
        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        
        // If any is zero
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        
        int n = s1.length();
        int m = s2.length();
        
        int[] result = new int[n + m];
        
        // Multiply like school method
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        
        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        while (i < result.length) {
            sb.append(result[i++]);
        }
        
        if (negative) sb.insert(0, '-');
        
        return sb.toString();
    }
    
    private String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
