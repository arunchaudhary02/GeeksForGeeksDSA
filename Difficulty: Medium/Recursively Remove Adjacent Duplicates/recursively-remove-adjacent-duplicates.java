//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String S = br.readLine();
            Solution ob = new Solution();

            String s = ob.removeUtil(S);
            if (s.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(s);
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeUtil(String s) {
        // code here
        StringBuilder result = new StringBuilder();
        int n = s.length();
        
        for(int i = 0; i < s.length(); i++) {
            
            boolean repeat = false;
            
            while(i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                repeat = true;
                i++;
            }
            
            if(!repeat) {
                result.append(s.charAt(i));
            }
            
        }
        
        if(n == result.length()) {
            return result.toString();
        }
        
        return removeUtil(result.toString());
    }
}